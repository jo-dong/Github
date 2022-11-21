package himedia.secondspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.exceptions.TemplateProcessingException;

import himedia.secondspring.domain.Member;
import himedia.secondspring.domain.MemberForm;
import himedia.secondspring.service.MemberService;

@Controller
public class MarketController {
	// 의존성 주입이 파일이 많아서 한눈에 안보여서 관리가 귀찮음 -> 한 개의 파일에서 관리 가능 
	// => Configuration
	
	// 이렇게 해도 되긴 되는데 Spring Boot가 자동으로 의존성 주입을 해주기 때문에 이렇게 하지 않음
//	private final MemberService memberService = new MemberService(new MemoryMemberRepository());
	
	// 고정 객체를 전달받는 것이 아닌 MemberService type이면 모든 걸 받게 한다.
	private final MemberService memberService;
	
	// 의존성 주입 전제 조건
	// 1. method여야 한다.(주로 생성자)
	// 2. 매개변수가 있어야 한다.
	// 3. 매개변수의 객체(bean)가 미리 만들어져 있어야 한다.
	// 4. 의존성 주입이 필요한 method를 알려줘야 함
	
//	@Autowired : 의존성 주입(DI - 생성자를 통한 DI) -> 생성자가 1개만 있을 때는 안 해줘도 됨
//	MemberService에 bean을 생성해 줘야 함 / Service Layer : @Service / Repository Layer : @Repository
	public MarketController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/")
	public String welcomePage() {
		return "welcome";
	}
	
	@GetMapping("/members/new")
	public String join() {
		return "members/newForm";
	}
	
	@PostMapping("/members/new")
	public String form(MemberForm memberForm) {
		// 이름 입력
		Member member = new Member();
//		member.setName(memberForm.getName());
		member.setName(memberForm.getUserName());
		System.out.println("member name >> " + member.getName()); // 주석 처리
		// 이름 저장
		memberService.join(member);
//		return "welcome";
		return "redirect:/";	// 띄어쓰기 하면 Error
		// redirect : client와 server 사이에 request/response가 순차적으로 발생
		// 근데 response 이후 request를 기다리는 지연 시간이 생김
		// 그래서 response를 하고 request 받는 척 하는 기능 : redirect
		// 지연 시간 줄일 수 있음 // url도 localhost:8080으로 다시 바뀜
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> member = memberService.findMember();
		model.addAttribute("member", member);
		return "members/memberList";
	}
	
	@GetMapping("/members/search")
	public String search(Long id, String name, Model model) {
		Optional<Member> member1 = memberService.findOne(id);
		Optional<Member> member2 = memberService.findTwo(name);
		if(member1.isEmpty()) {
			if(member2.isPresent()) {
				model.addAttribute("member", member2.get());
				return "members/memberSearch";
			}
			return "members/memberSearch";
		}
		else {
			if(member2.isEmpty()) {
				model.addAttribute("member", member1.get());
				return "members/memberSearch";
			}
			model.addAttribute("member", member1.get());
			return "members/memberSearch";
		}
	}
	
//	@GetMapping("/members/search")
//	public String searchByName(String name, Model model) {
//		Optional<Member> member = memberService.findTwo(name);
//		if(member.isEmpty()) {
//			return "members/memberSearch";
//		}
//		else {
//			model.addAttribute("member", member.get());
//			return "members/memberSearch";
//		}
//	}
	
}
