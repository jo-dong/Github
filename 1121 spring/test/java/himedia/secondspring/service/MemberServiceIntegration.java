package himedia.secondspring.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.secondspring.domain.Member;

					// Spring Container와 Test를 함께 실행
@SpringBootTest		// Test를 할 때에도 SpringBoot를 실행 시킴 : config 파일을 실행하여 bean 생성 - DB 사용이 필요할 때
@Transactional		// Test 진행 동안에 입력한 데이터는 실제로 DB에 넣지 마십시오~ 라는 Annotation (실행 후 자동 Rollback)
					// 근데 id는 증가함
class MemberServiceIntegration {

	// 자동 객체 생성
//	@Autowired JdbcTemplateMemberRepository memberRepository;
	@Autowired MemberService memberService;
		
	@Test
	void join() {
		// given : 어떤 데이터를 - Member 객체의 one 사용자
		Member member = new Member();
		member.setName("one");
		
		// when : 무엇을 검증할 것이냐 - 가입 여부
		Long saveId = memberService.join(member);
		
		// then : 검증 - 가입한 사용자 one == 저장된 사용자 one(객체 주소 비교)
		Member findMember = memberService.findOne(saveId).get();	// findOne 메소드 리턴 타입이 Optional => .get()
//		assertThat(member).isEqualTo(findMember);					// 객체 주소
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	void checkDoubleId() {
		// given
		Member member1 = new Member();
		member1.setName("two");
		
		Member member2 = new Member();
		member2.setName("two");
		
		// when
		Long id1 = memberService.join(member1);
		Long id2 = memberService.join(member2);
		
		// then
		Member check1 = memberService.findOne(id1).get();
		Member check2 = memberService.findOne(id2).get();
		assertThat(check1.getName()).isEqualTo(check2.getName());
		
	}

}
