package himedia.seventhspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.seventhspring.domain.Item;
import himedia.seventhspring.repository.JdbcItemRepository;
import lombok.RequiredArgsConstructor;

//@RequestMapping("/store/items")
//@RequiredArgsConstructor		
//@Controller
public class JdbcItemController {

	private final JdbcItemRepository repository;
	
	@Autowired
	public JdbcItemController(JdbcItemRepository repository) {
		this.repository = repository;
	}
	
	// 상품 목록
	@GetMapping
	public String items(Model model) {
		List<Item> item = repository.findAll();
		model.addAttribute("item", item);
		return "store/items";
	}
	
	// 상품 상세
	@GetMapping("/{itemId}")
	public String showItem(@PathVariable Integer itemId, Model model) {
		Item item = repository.findById((long)itemId).get();
		model.addAttribute("item", item);
		return "store/item";
	}
	
	// 상품 등록 화면 불러오기
	@GetMapping("/add")
	public String add() {
		return "store/addForm";
	}
	
	/**
	 * [상품 등록]
	 * <방법1> 
	 * - 사용자가 새로고침(F5)을 누르면, POST 요청을 계속해서 재요청한다.
	 * - 문제점 : 같은 데이터가 계속 등록(저장)된다.
	 * - 원인 	: F5를 하면, 마지막 작업(POST)이 반복된다.
	 */
//	@PostMapping("/add")
//	public String addSave(@ModelAttribute Item item) {
//		itemRepository.save(item);
//		return "/store/item";
//	}
	
	/**
	 * [상품 등록]
	 * <방법2> 
	 * - 사용자가 새로고침(F5)을 누르면, GET 요청한다.
	 * - redirect를 해주면 새로고침을 해도 GET으로 요청되기 때문에 계속해서 등록되지 않는다.
	 * - PRG 패턴 : Post -> Redirect -> Get
	 * 
	 * - 문제점 : 재요청하면, encoding이 안된다.
	 */
//	@PostMapping("/add")
//	public String addSave(@ModelAttribute Item item) {
//		itemRepository.save(item);
//		return "redirect:/store/items/" + item.getItemName();
//	}
	
	/**
	 * [상품 등록]
	 * <방법3> 
	 * - RedirectAttributes interface를 사용한다.
	 * - RedirectAttributes의 addAttribute를 사용하면, 응답 URI에 변수를 사용할 수 있다.
	 * - 응답 URI에 사용하지 않은 addAttribute한 변수는 Query string으로 추가된다. 
	 */
	@PostMapping("/add")
	public String addSave(Item item, RedirectAttributes redirectAttributes) {
		Item savedItem = repository.save(item);
		redirectAttributes.addAttribute("itemId", savedItem.getItemId());
		redirectAttributes.addAttribute("itemName", savedItem.getItemName());
		return "redirect:/store/items/{itemId}";
	}
	
	// 상품 수정 화면 불러오기
	@GetMapping("/{itemId}/edit")
	public String update(@PathVariable Integer itemId, Model model) {
		model.addAttribute((long)itemId);
		return "store/editForm";
	}
	
	// 상품 수정
	@PutMapping("/{itemId}/edit")
	public String editForm(@PathVariable Integer itemId, Item item) {
		repository.update((long)itemId, item);
		return "redirect:/store/items";
	}
	
	// 이름 검색 시
	@PostMapping("/search")
	public String search(@RequestParam String itemName, RedirectAttributes redirectAttributes) {
		Optional<Item> item = repository.findByName(itemName);
		redirectAttributes.addAttribute("itemId", item.get().getItemId());
		return "redirect:/store/items/{itemId}";
	}
	
}