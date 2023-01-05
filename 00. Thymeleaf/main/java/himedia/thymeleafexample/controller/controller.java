package himedia.thymeleafexample.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import himedia.thymeleafexample.domain.Item;

@Controller
public class controller {
	/**
	 * 1. 텍스트, 지역변수
	 */
	@GetMapping("/first")
	String first(Model model) {
		model.addAttribute("test", "WHY?");
		model.addAttribute("num", 10);
		return "basic/ex-01";
	}
	
	/**
	 * 2. 조건 표현식 
	 */
	@GetMapping("/second")
	ModelAndView second() {
		ModelAndView mav = new ModelAndView("basic/ex-02");
		mav.addObject("test", "WHY?");
		return mav;
	}
	
	/**
	 * 3. 반복문, 상태 변수
	 */
	@GetMapping("/third")
	ModelAndView third() {
		ModelAndView mav = new ModelAndView("basic/ex-03");
		
		List<Item> items = Arrays.asList(
				new Item(1L, "TestA", 1000, 10),
				new Item(2L, "TestB", 2000, 20),
				new Item(3L, "TestC", 3000, 30)
		);
		
		mav.addObject("items", items);		
		return mav;
	}
	
	/**
	 * 4. text vs utext
	 */
	@GetMapping("/fourth")
	ModelAndView fourth() {
		ModelAndView mav = new ModelAndView("basic/ex-04");
		mav.addObject("element", "<p>추가된 엘리먼트</p>");
		return mav;
	}
	
	/**
	 * 5. Link URLs
	 */
	@GetMapping("/fifth")
	ModelAndView fifth() {
		ModelAndView mav = new ModelAndView("basic/ex-05");
		mav.addObject("id", 5);
		return mav;
	}
	
	/**
	 * 6. switch
	 */
	@GetMapping("sixth")
	ModelAndView sixth() {
		ModelAndView mav = new ModelAndView("basic/ex-06");
		mav.addObject("greeting", "hi");
		return mav;
	}
	
	/**
	 * 7. 주석 (comment)
	 */
	@GetMapping("seventh")
	ModelAndView seventh() {
		ModelAndView mav = new ModelAndView("basic/ex-07");
		return mav;
	}

	/**
	 * 8. fragment
	 */
	@GetMapping("/eighth")
	ModelAndView main() {
		ModelAndView mav = new ModelAndView("basic/ex-08");
		mav.addObject("element", "<p>추가된 엘리먼트</p>");
		return mav;
	}
	
	/**
	 * 9. layout
	 */
	@GetMapping("/index")
	String index() {
		return "layout/index";
	}
	
	@GetMapping("/table-view")
	String tableView() {
		return "layout/table-view";
	}
	
	@GetMapping("/list-view")
	String listView() {
		return "layout/list-view";
	}
	
	
	/**
	 * 10. layoutTwo
	 */
	@GetMapping("/layout-two/index")
	String indexTwo() {
		return "layoutTwo/index";
	}
	
	@GetMapping("/layout-two/table-view")
	String tableViewTwo() {
		return "layoutTwo/table-view";
	}
	
	@GetMapping("/layout-two/list-view")
	String listViewTwo() {
		return "layoutTwo/list-view";
	}
}