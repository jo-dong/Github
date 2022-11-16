package himedia.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarketController {

	@GetMapping("select-item")
	public String selectItem(@RequestParam("user_name") String user, 
							 @RequestParam("item_name") String item, 
							 Model model) {
		String str = user + " 고객님께서 선택한 상품은 " 
				   + item + "입니다.";
		model.addAttribute("user_item", str);
		return "select-item";
	}
	
	@RequestMapping("../index.html")
	public String welcomePage() {
		return "index.html";
	}
	
	@RequestMapping("order/order-detail")
	public String orderDetail() {
		return "order/order-detail";
	}
	
}
