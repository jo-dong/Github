package himedia.sixthspring.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHttpMethod {
	
	/**	==[URI 설계]====================================================
	 *			   Method			URI					Idempotent
	 * [회원 조회] : GET		  /members						O
	 * [회원 가입] : POST		  /members						X
	 * [회원 검색] : GET		  /members/{memberId}			O
	 * [전체 수정] : PUT		  /members/{memberId}			O
	 * [일부 수정] : PATCH	  /members/{memberId}			O
	 * [회원 탈퇴] : DELETE	  /members/{memberId}			O
	 * ================================================================
	 * 
	 * 멱등법칙(Idempotent)
	 * : 연산, 작업을 여러 번 실행해도 
	 * 	 결과가 달라지지 않는 성질
	 */
	
//	GET - resource 조회
	@GetMapping("/members")
	public String member() {
		return "[회원 조회] GET";
	}
	
//	POST - resource 생성
	@PostMapping("/members") 
	public String signUp() {
		return "[회원 가입] POST";
	}
	
//	GET - resource 조회
	@GetMapping("/members/{memberId}")
	public String findMember(@PathVariable String memberId) {
		return "[회원 검색] GET : " + memberId;
	}
	
//	PUT - resource 전체 수정
	@PutMapping("/members/{memberId}")
	public String updatePut(@PathVariable String memberId) {
		return "[전체 수정] PUT : " + memberId;
	}
	
//	PATCH - resource 일부 수정
	@PatchMapping("/members/{memberId}")
	public String updatePatch(@PathVariable String memberId) {
		return "[일부 수정] PATCH : " + memberId;
	}
	
//	DELETE - resource 삭제
	@DeleteMapping("/members/{memberId}")
	public String delete(@PathVariable String memberId) {
		return "[회원 탈퇴] DELETE : " + memberId;
	}
	
}
