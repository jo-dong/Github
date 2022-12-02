package himedia.examproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.examproject.domain.Item;
import himedia.examproject.repository.ItemRepository;

@Controller
@RequestMapping("/store/items")
public class ItemController {
	
	private final ItemRepository repo;
	
	@Autowired
	public ItemController(ItemRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public String showList(Model model) {
		List<Item> item = repo.findAll();
		model.addAttribute("item", item);
		return "store/items";
	}
	
	@GetMapping("/{itemId}")
	public String showItem(@PathVariable Integer itemId, Model model) {
		Item item = repo.findById((long)itemId);
		model.addAttribute("item", item);
		return "store/item";
	}
	
	@GetMapping("/add")
	public String add() {
		return "store/addForm";
	}
	
	@PostMapping("/add")
	public String addForm(@ModelAttribute Item item) {
		repo.save(item);
		return "redirect:";
	}
	
	@GetMapping("/{itemId}/edit")
	public String update(@PathVariable Long itemId) {
		return "store/editForm";
	}
	
	@PutMapping("/{itemId}/edit")
	public String editForm(@PathVariable Integer itemId, Item item) {
		repo.update((long)itemId, item);
		return "redirect:";
	}
	
}
