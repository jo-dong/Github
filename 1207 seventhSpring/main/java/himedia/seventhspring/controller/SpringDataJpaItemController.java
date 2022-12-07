package himedia.seventhspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.seventhspring.domain.Item;
import himedia.seventhspring.repository.SpringDataJpaItemRepository;
import lombok.RequiredArgsConstructor;

@RequestMapping("/store/items")
@RequiredArgsConstructor		
@Controller
public class SpringDataJpaItemController {
	
	private final SpringDataJpaItemRepository repository;
	
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
	
	// 상품 등록
	@PostMapping("/add")
	public String addSave(Item item, RedirectAttributes redirectAttributes) {
		Item savedItem = repository.save(item);
		redirectAttributes.addAttribute("itemId", savedItem.getItemId());
		redirectAttributes.addAttribute("itemName", savedItem.getItemName());
		return "redirect:/store/items";
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
		Optional<Item> item = repository.findByItemName(itemName);
		redirectAttributes.addAttribute("itemId", item.get().getItemId());
		return "redirect:/store/items/{itemId}";
	}
}
