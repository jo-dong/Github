package himedia.eighthspring.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.eighthspring.domain.DeliveryCode;
import himedia.eighthspring.domain.Item;
import himedia.eighthspring.domain.ItemType;
import himedia.eighthspring.repository.ItemInterfaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/store/items")
@RequiredArgsConstructor
@Controller
@Slf4j
public class ItemController {
	
	private final ItemInterfaceRepository itemRepository;
	
	//private final ItemRepository itemRepository;
	
//	@Autowired
//	public ItemController(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}
	
		
	/**
	 * [상품 목록] ==========================================
	 */
	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		log.info("[상품 목록] 상품 배송 방식 ==> {}", items.get(0).getDeliveryCode());
		return "store/items";
	}
	
	/**
	 * [상품 상세 페이지] ===================================
	 */
	@GetMapping("/{itemId}")
	public String item(@PathVariable Long itemId, Model model) {
		Item item = itemRepository.findById(itemId).get();
		model.addAttribute("item", item);
		log.info("[상품 상세 페이지] 상품 종류 ==> {}", item.getItemType());
		log.info("[상품 상세 페이지] 상품 배송 방식 ==> {}", item.getDeliveryCode());
		return "store/item";
	}	
	
	/**
	 * [상품 수정] - 화면(폼) ==================================
	 */
	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model) {
		Item item = itemRepository.findById(itemId).get();
		model.addAttribute("item", item);
		return "store/editForm";		
	}
	
	/**
	 * [상품 수정] - 저장 ======================================
	 */
	@PostMapping("/{itemId}/edit")
	public String editSave(@PathVariable Long itemId, @ModelAttribute Item item) {
		log.info("[상품 수정] - 저장 : 상품 종류 ==> {}", item.getItemType());
		itemRepository.update(itemId, item);
		return "redirect:/store/items/{itemId}";
	}
	
	/**
	 * [상품 등록] - 화면(폼) ==================================
	 */
//	@GetMapping("/add")
//	public String addForm() {
//		return "store/addForm";
//	}
	
	// th:object를 적용하기 위해서는 Object 필요
	// 등록폼이기때문에, 빈 Object 넘김
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("item", new Item());
		return "store/addForm";
	}
	
	/**
	 * [상품 등록] - 저장 =======================================
	 * 
	 * 새로고침(F5)을 하면, POST 재요청
	 * 문제점 : 같은 데이터 계속 등록(저장)
	 * 원  인 : F5를 하면, 마지막 작업(POST)을 서버에 요청
	 * 해  결 : RedirectAttributes - [PRG] Post -> Redirect -> Get
	 */

	@PostMapping("/add")
	public String add(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
		// [check box]
		// check 되었을 경우 		: 	item.open ==> true 
		//								client에서 넘어오는 값은 true가 아니고, on 이다. 
		// check 되지 않았을 경우 	: 	item.open ==> null
		//								체크(선택)되지 않았기 때문에, 아무 값도 넘어오지 않는다.
		//								체크(선택)하지 않았음을 server가 알기위해, 보통 hidden field를 만든다.
		//								hidden field의 이름은 기존 체크박스 이름에 _를 붙여 사용한다.
		log.info("item.open ==> {}", item.getOpen());		
		log.info("item.regions ==> {}", item.getRegions());
		log.info("item.itemType ==> {}", item.getItemType());
		
		Item savedItem = itemRepository.save(item);
		redirectAttributes.addAttribute("itemId", savedItem.getId());
		//redirectAttributes.addAttribute("itemName", savedItem.getItemName());
		return "redirect:/store/items/{itemId}";
	}
	
	/**
	 * [추가된 코드] =================================================================
	 * 
	 * cf) @ModelAttribute 있는 메서드는 컨트롤러가 호출될 때마다 자동으로 사용됨
	 *     따라서, 메서드 내 class type이 있다면 해당 객체도 호출될 때마다 생성됨
	 */
	
	/**
	 * 
	 * [지역 선택 : 체크 박스]
	 * item.html, editForm.html, addForm.html 에서 체크 박스로 사용할 예정
	 * Model에 담아 view로 넘겨서 check box로 표시 
	 */
	@ModelAttribute("regions")
	public Map<String, String> regions() {
		// 특별시, 특별자치시, 도, 광역자치단체
		Map<String, String> regions = new LinkedHashMap<>();
		regions.put("SEOUL", "서울");
		regions.put("INCHEON", "인천");
		regions.put("DAEGU", "대구");
		regions.put("GWANGJU", "광주");
		regions.put("DAEJEON", "대전");
		regions.put("ULSAN", "울산");		
		regions.put("BUSAN", "부산");
		regions.put("JEJU", "제주");
		return regions;
	}
	
	/**
	 * [상품 종류 : 라디오 버튼]
	 * item.html, editForm.html, addForm.html 에서 라디오 버튼으로 사용할 예정
	 * ItemType.values() : ENUM의 모든 정보를 배열로 리턴
	 */
	@ModelAttribute("itemTypes")
	public ItemType[] itemType() {
		return ItemType.values();
	}
	
	/**
	 * [배송 방식 : select box] - 하나만 선택
	 *  | 당일 배송
	 *  | 보통 배송
	 *  | 느린 배송
	 */
	@ModelAttribute("deliveryCodes")
	public List<DeliveryCode> deliveryCodes() {
		List<DeliveryCode> deliveryCodes = new ArrayList<>();
		deliveryCodes.add(new DeliveryCode("TODAY", "당일 배송"));
		deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
		deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));
		return deliveryCodes;
	}
	
	@GetMapping("/search")
	public String find(@RequestParam("search") String search, RedirectAttributes redirectAttributes) {
		System.out.println("실행됨");

		Item savedItem = itemRepository.findByName(search).get();
		System.out.println();
		redirectAttributes.addAttribute("itemId", savedItem.getId());
		return "redirect:/store/items/{itemId}";
	}
}
