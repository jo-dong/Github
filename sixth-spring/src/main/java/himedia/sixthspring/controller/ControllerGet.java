package himedia.sixthspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.sixthspring.domain.Member;

@Controller		// Spring Boot = Annotation 기반 프로그래밍
public class ControllerGet {
	
	// @GetMapping을 Method에 붙인다 : Method Level
	@GetMapping("/search")			// url Request(관용적으로 앞에 / 붙여줌)
	public String search() {
		System.out.println("search method running...");
		return "item/item-search";	// 논리적 view(Response)
		// [HTML page] 단어와 단어 사이엔 하이픈(-)을 사용하는 것이 일반적
	}
	
	// [Exception 발생] ---------------------------------------------------------
	@GetMapping("/detail")	// Annotation 안에 넣는 ↓ : 속성(Attribute)  
	public String detail(@RequestParam(value="itemName", required=false) String itemName) {
		System.out.println("itemName 확인 >> " + itemName);
		return "item/item-detail";
	}
//	----------------------------------------------------------------------------
	
	// Exception 해결법 1 : Set required=false ----------------------------------
//	@GetMapping("/detail")
//	@ResponseBody
//	public String detail(@RequestParam(name="itemName", required=false) String itemName) {
//		System.out.println("itemName 확인 >> " + itemName);
//		return itemName;
//	}
//	----------------------------------------------------------------------------
	
	// Exception 해결법 2 : Set defaultValue="default" --------------------------
//	@GetMapping("/detail")
//	@ResponseBody
//	public String detail(@RequestParam(name="itemName", defaultValue="default") String itemName) {
//		System.out.println("itemName 확인 >> " + itemName);
//		return itemName;
//	}
//	----------------------------------------------------------------------------
	
	// Exception 해결법 3 : Using 'Optional' keyword ----------------------------
	// [Q] Optional을 이용하여,
	// 1. query parameter의 key, value가 있을 경우, 값 리턴
	// 2. query parameter의 value가 없을 경우, default 리턴
	// 3. query parameter의 key, value가 없을 경우, default 리턴
	// [내 답] ====================
//	@GetMapping("/detail")
//	@ResponseBody
//	public Optional<String> detail(@RequestParam(name="itemName") Optional<String> itemName) {
//		System.out.println("itemName 확인 >> " + itemName);
//		if(itemName.isEmpty() || itemName.equals(Optional.of(""))) {
//			itemName = Optional.of("default");
//			return itemName;
//		}
//		return itemName;
//	}
	// [강사님 답] =================
//	@GetMapping("/detail")
//	@ResponseBody
//	public String detail(@RequestParam(name="itemName") Optional<String> itemName) {
//		System.out.println("itemName 확인 >> " + itemName);
//		if(itemName.isEmpty() || itemName.get().isEmpty()) {
//			return "default";
//		}
//		return itemName.get();
//	}
//	----------------------------------------------------------------------------
	
	// [문제] 기본값 0 설정, 파라미터 필수 입력(required=true)
	@GetMapping("/count")
	public String count(@RequestParam(defaultValue="0") Integer itemCount) {
		System.out.println("itemCount 확인 >> " + itemCount);
		return "item/item-count";
	}
	
	// 예전 스타일
	@RequestMapping(value = "/order", method=RequestMethod.POST)
	public String oldStyle(HttpServletRequest request, HttpServletResponse response) {
		String itemName = request.getParameter("itemName");
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		
		System.out.println("상품명 : " + itemName);
		System.out.println("개수 : " + itemCount);
		
		return "item/item-order";
	}
	
	// 요즘 스타일 (Spring 4.3부터 지원 : GetMapping, PostMapping)
	@GetMapping(value = "/order") // Property의 값을 매개변수에 저장 -> Binding
	public String newStyle(@RequestParam(value="itemName", required=false) String itemName,
						   @RequestParam(value="itemCount", required=false) int itemCount) {
		System.out.println("상품명 : " + itemName);
		System.out.println("개수 : " + itemCount);
		
		return "item/item-order";
	}
	
	// [생략 1]
	// QueryParameter의 key와  Method의 Parameter의 이름이 같은 경우,
	// QueryParameter의 key 생략 가능
//	@GetMapping(value = "/order")	// required=true -> 값이 안들어오면 Error
//	public String newStyle(@RequestParam String itemName,
//						   @RequestParam Integer itemCount) {
//		System.out.println("상품명 : " + itemName);
//		System.out.println("개수 : " + itemCount);
//		
//		return "item/item-order";
//	}
	
	// [생략 2]
	// QueryParameter의 key와  Method의 Parameter의 이름이 같고,
	// Method의 Parameter의 Type이 기본 자료형(int, float, String, ...)인 경우,
	// @RequestParam까지 생략 가능
//	@GetMapping(value = "/order")	// required=false로 자동 설정됨 -> 값이 안들어와도 No Error	
//	public String newStyle(String itemName, Integer itemCount) {
//		System.out.println("상품명 : " + itemName);
//		System.out.println("개수 : " + itemCount);
//		
//		return "item/item-order";
//	}
	
	// ===================================================
	// [parameter에서 사용되는 @ModelAttribute와 Model의 차이]
	// -----------------[@ModelAttribute]-----------------
	// : Data 이동 : view -> controller(front -> back)
	// : 주로 수정, 등록에 사용
	// ----------------[Model(Interface)]-----------------
	// : Data 이동 : controller -> view
	// : model.addAttribute(key, value);
	// ===================================================
	
	@GetMapping("/cancel")
	public String cancel(Member member, Model model) {
		System.out.println("name >> " + member.getName());
		System.out.println("age >> " + member.getAge());
		
//		model.addAttribute("name", member.getName());
//		model.addAttribute("age", member.getAge());
		
		return "/member/member-cancel";
	}
	
}
