package himedia.fifthspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import himedia.fifthspring.domain.Member;
import himedia.fifthspring.domain.MemberForm;
import himedia.fifthspring.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService service;
	
	@Autowired
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	@GetMapping("/member/new")
	public String form() {
		return "member/newForm";
	}
	
	@PostMapping("/member/new")
	public String signUp(MemberForm memberForm) {
		Member member = new Member();
		member.setName(memberForm.getName());
		System.out.println("name >> " + member.getName());
		service.join(member);
		return "redirect:/";
	}
	
	@GetMapping("/member/list")
	public String list(Model model) {
		List<Member> member = service.findAllMembers();
		model.addAttribute("member", member);
		return "member/memberList";
	}
}
