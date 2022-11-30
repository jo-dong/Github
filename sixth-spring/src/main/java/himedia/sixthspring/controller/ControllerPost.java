package himedia.sixthspring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import himedia.sixthspring.domain.Member;
import himedia.sixthspring.domain.Product;

//@RestController
@Controller
public class ControllerPost {

	// [@RequestParam] - 사용 가능하지만 굳이..? ----------------------------------
	// localhost:8080/buy
	@PostMapping("/buy")
	public String buy(@RequestParam(name="name") String name,
					  @RequestParam(name="price") int price) {
		return "상품명 : " + name + ", 가격 : " + price;
	}
	
	// [Map] ---------------------------------------------------------------------
	// localhost:8080/sell
	@PostMapping("/sell")
	public String sell(@RequestParam Map<String, Object> map) {
		return "상품명 : " + map.get("name") + ", 가격 : " + map.get("price");
	}
	
//	======================================================================================
	// [Domain] ------------------------------------------------------------------
	//			- @RequestBody 사용하면 HttpMediaTypeNotSupportedException 발생(x-www-form-urlencoded)
	// 		    - @RequestBody 사용하려면 json 형태로 사용해야함(json 입력을 받아야함) 
	//          - ★JSON으로 데이터를 받을 때에는 @RequestBody 사용★
	
	// [@RequestBody]--------------------------------------------------------------
//	@PostMapping("/share")
//	public String share(@RequestBody Product product) {
//		return "상품명 : " + product.getName() + ", 가격 : " + product.getPrice();
//	}
	
	// [@ModelAttribute]------------------------------------------------------------
//	@PostMapping("/share")
//	public String share(@ModelAttribute Product product) {
//		return "상품명 : " + product.getName() + ", 가격 : " + product.getPrice();
//	}
	
	// 생략 가능 (근데 @RequestBody를 생략한 것이 아니라 @ModelAttribute(or @RequestParam)을 생략한 것)
	@PostMapping("/share")
	public String share(Product product) {
		return "상품명 : " + product.getName() + ", 가격 : " + product.getPrice();
	}
	
	// [응용]
	@PostMapping("/join")
	public Member join(@RequestBody Member member) {
		System.out.println("name : " + member.getName());
		System.out.println("age : " + member.getAge());
		return member;
	}
//	======================================================================================
	
	// [ModelAndView] - Model(=Domain), View(=View)
	@PostMapping("/find")
	public ModelAndView find() {							// 논리 뷰
//		ModelAndView mav = new ModelAndView("/member/path-join");
//		ModelAndView mav2 = mav.addObject("name", "홍길동");
		ModelAndView mav = new ModelAndView("/member/path-join").addObject("name", "홍길동");
		return mav;
	}
	// (Body:none)Send -> TemplateInputException 발생
	// 원인 : 해당 view 없음 
	// 해결 --> 해당 view 만들면 됨
	// ModelAndView를 왜 사용하는지(어딘가 편리한 구석이 있음) 
	// : view 이동과 Data 처리를 한 번에 할 수 있음
	
	// [문제]
	// Post 방식으로 이름과 나이를 view로부터 받아서, /member/member-quiz view를 client에게 response.
	// member-quiz view에 이름과 나이를 출력. (1. 일반적인 형태, 2. ModelAndView)
	// 1번 메소드 이름 quizOne, 2번 메소드 이름 quizTwo
	// 요청 url : /quiz
	@PostMapping("/quiz1")
	public String quizOne(@RequestBody Member member, Model model) {
		System.out.println("name : " + member.getName());
		System.out.println("age : " + member.getAge());
		model.addAttribute(member); 
// 		를 생략하면 member data가 model에 저장이 되지 않는다.
		return "member/member-quiz";
	}
	
	@PostMapping("/quiz2")
	public ModelAndView quizTwo(@RequestBody Member member) {
		ModelAndView mav = new ModelAndView("member/member-quiz")
						   .addObject(member);
		return mav;
	}
	
	
	
	
}
