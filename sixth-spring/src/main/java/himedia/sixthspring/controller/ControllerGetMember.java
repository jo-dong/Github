package himedia.sixthspring.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import himedia.sixthspring.domain.Member;

@RequestMapping("/members")
//@ResponseBody			// : 물리적 view가 없이도 request를 확인하기 위해 문자열을 보냄
//@Controller			// -> view 없이 controller test
@RestController			// => @ResponseBody + @Controller
public class ControllerGetMember {

//	@ResponseBody	
//	@GetMapping("/members/new")
	@GetMapping("/new")
	public String memberNew() {
		return "new-ok";
	}
	
//	@ResponseBody
//	@GetMapping("/members/list")
	@GetMapping("/list")
	public String memberList() {
		return "list-ok";
	}
	
	// 여러 개의 Request 처리 방법
	// localhost:8080/members/hi
	// localhost:8080/members/hello
	@GetMapping(value={"/hello", "/hi"})
	public String greeting() {
		return "hello or hi";
	}
	
//	================= Paging =================
//	url : localhost:8080/members/reservations/2
	@GetMapping(value="/reservations/{page}")								// @PathVariable
	public String reservation(@PathVariable(name="page") Integer page) {	// : 경로를 변수처럼 사용하겠다.
		return "reservation-" + page + "-ok";
	}
	
	// [문제] url : localhost:8080/members/store/{업체명}/product/{상품ID}
	@GetMapping(value="/store/{company}/products/{id}")
	public String smartStore(@PathVariable String company,
							 @PathVariable Long id) {		// Long or String
		return "회사명 : " + company + ", 상품 번호 : " + id;
	}
	
	// [url] localhost:8080/members/check?id=abc123 ===================================
	// [기존 방법]
//	@GetMapping(value="/check")
//	public String chech(@RequestParam("id") String id) {
//		return "check-" + id + "-ok";
//	}
	
	// [New] - Collection Framework(Map -> Key, Value)
	@GetMapping(value="/check")	   // Map<String, Object>
	public String check(@RequestParam Map<String, String> map) {
		// Map을 return에도 사용 가능
		return "check-" + map.get("id") + "-" + map.get("password") + "-ok";
//		return "check-" + map.get("id").concat("-") + map.get("password") + "-ok"; 
//		=> 아래 리턴문은 key, value가 입력되지 않을 때(8080/members/check?) concat이 null을 처리하지 못해서
//		   NPE 발생
	}
//	=====================================================================================
	// 근데 Map은 key가 중복이 안됨 -> 중복 선택이 필요할 때(ex] 취미 = 축구, 독서, ...)
	
	// [url] localhost:8080/members/hobby?select=reading&select=music ===================
	@GetMapping("/hobby")		   // MultiValueMap => key 1개에 여러 value 저장 가능
	public String hobby(@RequestParam MultiValueMap<String, String> multi) {
		System.out.println(multi.size());		// select=reading&select=music => multi.size() = 1 / key는 1개
		// [문제] 값 출력 - console
		Iterator<Entry<String, List<String>>> iter = multi.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, List<String>> entry = iter.next();
			System.out.print("key : " + entry.getKey().concat(", "));
			System.out.println("value : " + entry.getValue());
		}
//		---------------------------------------------------------------------------
		// 강사님 답 - key가 select로 고정
//		for(String s : multi.get("select"))
//			System.out.println(s);
		return "hobby - ok";
	}
	
	// 11.29(화) =============================================================================
	// [url] localhost:8080/members/cancel?name=홍길동&age=25
	// [기존 방식 - 가장 일반적 형태(@RequestParam)]
//	@GetMapping("cancel")
//	public String cancel(@RequestParam("name") String name,
//						 @RequestParam("age") int age) {
//		System.out.println("이름 >> " + name);
//		System.out.println("나이 >> " + age);
//		return "cancel-ok";
//	}
	
	// @ModelAttribute 정리==================================================================
	// [@ModelAttribute 실행 순서]
	// 1. Member 객체 생성
	// 2. 요청 Parameter 이름의 Property 검색
	// 3. Binding (해당 Property의 Setter를 호출하여 값 설정)
	//
	// ☆ 해당 Parameter(url)가 없으면 정수는 0, 참조 변수는 null로 자동 초기화
	// ☆ @ModelAttribute 생략 가능
	// 	 - cf) @RequestParam도 생략 가능 : 기본형(int, float,...), String
	//		   @ModelAttribute 생략 가능 : 참조형
	// ☆ BindException : Type MisMatch --> 예외 처리는 검증으로!
	// ======================================================================================
	
	// [Parameter : Domain 사용] - @ModelAttribute
	// [url] localhost:8080/members/cancel?name=홍길동&age=25		// id = null  ->  required=false
	// [url] localhost:8080/members/cancel?name=홍길동&level=25		// id = null, age = 0 -> id=>Long, age=>int
	@GetMapping("cancel")
//	public String cancel(@ModelAttribute Member member) { 	// 생략 가능	(@RequestParam, @ModelAttribute) 
	public String cancel(Member member) {					// 뭐가 생략된지는 type을 보면 알 수 있다.
		System.out.println("id >> " + member.getId());
		System.out.println("이름 >> " + member.getName());
		System.out.println("나이 >> " + member.getAge());
		return "cancel-ok";
	}
	
	// [요청 패턴] ===========================================================================
	// ?		: 한 글자
	// *		: 모든 글자, 한 경로
	// **		: 이하 모든 경로
	
	// [? : 한 글자] -------------------------------------------------------------------------
	// ex) localhost:8080/members/talk/a
	@GetMapping("/talk/?")
	public String questionMark() {
		return "questionMark";
	}
	
	// ex) localhost:8080/members/talk/a/hello
	@GetMapping("/talk/?/hello")
	public String questionMarkTwo() {
		return "questionMark2";
	}
	
	// ex) localhost:8080/members/talk/ab
	@GetMapping("/talk/??")
	public String questionMarkThree() {
		return "questionMark3";
	}
	
	// [* : 여러 글자, 단일 경로] --------------------------------------------------------------
	// ex) localhost:8080/members/talk/abc1234...
	@GetMapping("/talk/*")
	public String asterisk() {
		return "asterisk";
	}
	
	// [** : 여러 글자, 여러 경로(계층)] --------------------------------------------------------
	// ex) localhost:8080/members/talk/abc1234.../himyname.../1q2w...
	@GetMapping("/talk/**")
	public String doubleAsterisk() {
		return "double asterisk";
	}
	
}










