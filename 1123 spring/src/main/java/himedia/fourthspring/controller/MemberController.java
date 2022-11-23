package himedia.fourthspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.fourthspring.domain.MemberForm;
import himedia.fourthspring.domain.Member;
import himedia.fourthspring.service.MemberService;

@Controller
public class MemberController {
	
private final MemberService service;
	
	@Autowired
	public MemberController(MemberService service) {
		this.service = service;
	}

	@GetMapping("/member/new")
	public String newForm() {
		return "member/newForm";
	}
	
	@PostMapping("/member/new")
	public String signUp(MemberForm memberForm) {
		Member member = new Member();
		member.setName(memberForm.getName());
		service.join(member);
		return "redirect:/";
	}
	
	@GetMapping("/member/list")
	public String list(Model model) {
		List<Member> member = service.findAllMember();
		model.addAttribute("member", member);
		return "member/memberList";
	}
	
	@GetMapping("/member/search")
	public String searchId(@RequestParam("id") Long id, Model model) {
		Optional<Member> member = service.idFindMember(id);
		if(member.isEmpty()) 
			return "member/search";
		model.addAttribute("member", member.get());
		return "member/search";
	}
	
	@GetMapping("/member/searchName")
	public String searchName(@RequestParam("name") String name, Model model) {
		Optional<Member> member = service.nameFindMember(name);
		if(member.isEmpty()) 
			return "member/search";
		model.addAttribute("member", member.get());
		return "member/search";
	}
	
}