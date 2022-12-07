package himedia.seventhspring.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import himedia.seventhspring.domain.Item;
import himedia.seventhspring.repository.ItemRepository;

//@RequestMapping("/store/items")
//@RequiredArgsConstructor		// @Autowired 대체 Annotation - lombok
//@Controller
public class ItemController {

	private final ItemRepository repository;
	
	@Autowired
	public ItemController(ItemRepository repository) {
		this.repository = repository;
	}
	
	@PostConstruct	// 테스트를 위해 미리 데이터 작업
	public void testData() {
		repository.save(new Item("허쉬", 4630, 5));
		repository.save(new Item("바나나 우유", 1500, 8));
		repository.save(new Item("빼빼로", 1600, 11));
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
		Item item = repository.findById((long)itemId);
		model.addAttribute("item", item);
		return "store/item";
	}
	
	// 상품 등록 화면 불러오기
	@GetMapping("/add")
	public String add() {
		return "store/addForm";
	}
	
	// 상품 등록
	@PostMapping("/add")
	public String addForm(@ModelAttribute Item item) {
		repository.save(item);
		return "redirect:";
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
		return "redirect:store/items/{itemId}";
	}
}
