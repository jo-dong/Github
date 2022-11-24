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
import himedia.fourthspring.domain.SearchForm;
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
		String inputName = memberForm.getName();
		List<Member> list = service.findAllMember();
		for(Member m : list) {
			if(m.getName().equals(inputName)) {
				System.out.println("중복된 이름입니다.");
				return "redirect:/";
			}
		}
		member.setName(inputName);
		service.join(member);
		return "redirect:/";
	}
	
	@GetMapping("/member/list")
	public String list(Model model) {
		List<Member> member = service.findAllMember();
		model.addAttribute("member", member);
		return "member/memberList";
	}
	
	// id만 조회
//	@GetMapping("/member/search")
//	public String searchId(@RequestParam("id") Long id, Model model) {
//  ==> Member member = service.idFindMember(id).get();과 동일
//		Optional<Member> member = service.idFindMember(id);
//		Optional<Member> member1 = service.nameFindMember(name);
//		
//		// [해결법 1] 빈 객체 넘기기
////		if(member.isEmpty()) {
////			model.addAttribute("member", new Member());
////			return "member/search";
////		}
////		model.addAttribute("member", member.get());
////		return "member/search";
//		
//		// [해결법 2]
//		if(member.isPresent())
//			model.addAttribute("member", member.get());
//		return "member/search";
//	}
									// value, name 상관 없음(둘 다 똑같)
	// 이름, id 동시 조회(Get)		// required : 기본값이 true 빈 값 = 빈 문자열("")로 설정, 근데 이걸 Long이 못 받음
	@GetMapping("/member/search")	// 그걸 false로 바꿔 줌으로써 빈 값 = null로 설정
//	public String searchIdName(@RequestParam(value="id", defaultValue = "-1") Long id, 	// 빈 값에 들어갈 값 설정(String) 
//	public String searchIdName(@RequestParam(value="id") String id,  					// (1) String으로 사용 후
	public String search(@RequestParam(value="id", required=false) Long id,  			// Long id = null;
						 @RequestParam(name="name", required=false) String name, 		// String name = null;
						 Model model) {
		
		Optional<Member> member = Optional.empty();
		
//		if(!id.isEmpty())					// (2) 이런 식으로 해도됨
//			member = service.idFindMember(Long.parseLong(id));
		if(id!=null)
			member = service.idFindMember(id);
		else if(name!=null)
			member = service.nameFindMember(name);
		
		if(member.isPresent())
			model.addAttribute("member", member.get());
		return "member/search";
	}

	// 이름, id 동시 조회(Post)	- Method Overloading
	@PostMapping("/member/search")
	public String search(SearchForm searchForm, Model model) {
		
		Optional<Member> member = Optional.empty();
		Long id = searchForm.getId();
		String name = searchForm.getName();
		
		if(id != null) {
			member = service.idFindMember(id);
		}
		else if(!name.equals(null)) {
			member = service.nameFindMember(name);
		}
		
		if(member.isPresent())
			model.addAttribute("member", member.get());
		return "member/search";
	}
	
	
}