package himedia.sixthspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import himedia.sixthspring.domain.GoodDay;

@Controller
public class ControllerPostModel {
	
//	==================================================================
//	form을 통해서 HTTP Message Body에 기록되는 형태 
//	: (feeling=good&weather=cold) <==> Query Parameter
//	Json
//	: {"feeling":"good", "weather":"cold"}
//	 -> @RequestBody로만 처리가 가능 -> Model 생략 불가능
//	==================================================================
	
	// 생략 불가능
	// [형태 1] ----------------------------------------------------------
//	@PostMapping("/control")
//	public String control(@ModelAttribute GoodDay goodDay, Model model) {
//		System.out.println("feeling : " + goodDay.getFeeling());
//		System.out.println("weather : " + goodDay.getWeather());
//		
//		model.addAttribute("feeling", goodDay.getFeeling());
//		model.addAttribute("weather", goodDay.getWeather());
//		
//		return "/member/member-control";
//	}
	
	// data가 form에서 넘어오면 model.addAttribute(goodDay)를 생략해도 데이터 전송 가능
	// [형태 2] ----------------------------------------------------------
	// model.addAttribute 생략
//	@PostMapping("/control")
//	public String control(@ModelAttribute GoodDay goodDay, Model model) {
//		System.out.println("feeling : " + goodDay.getFeeling());
//		System.out.println("weather : " + goodDay.getWeather());
//		// [생략 가능]
////		model.addAttribute(goodDay);
//		
//		return "/member/member-control";
//	}
	
	// [형태 3] ----------------------------------------------------------
	// @ModelAttribute의 value 설정 : value="day" -> view로 넘어가는 bean의 이름이 됨
//	@PostMapping("/control")
//	public String control(@ModelAttribute("day") GoodDay goodDay, Model model) {
	
//		model.addAttribute(goodDay);
//		
//		return "/member/member-control";
//	}
	
	// [형태 4] ----------------------------------------------------------
	// Model model 생략(@ModelAttribute 어노테이션이 자동으로 다 해줌, 값 넣고 뷰에 보내는거 까지)
//	@PostMapping("/control")
//	public String control(@ModelAttribute GoodDay goodDay) {
	
//		model.addAttribute(goodDay);
//		
//		return "/member/member-control";
//	}
	
	// [형태 5] ----------------------------------------------------------
	// @ModelAttribute, Model model 생략
	@PostMapping("/control")
	public String control(GoodDay goodDay) {
		
//		model.addAttribute(goodDay);
		
		return "/member/member-control";
	}
	
}
