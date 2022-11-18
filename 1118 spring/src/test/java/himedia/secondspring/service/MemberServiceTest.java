package himedia.secondspring.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import himedia.secondspring.domain.Member;
import himedia.secondspring.repository.MemoryMemberRepository;

class MemberServiceTest {
	
	// [방법 1] - 메소드 실행 후 store에 저장된 모든 Node 삭제법 (for Test)
//	MemberService memberService = new MemberService(new MemoryMemberRepository());
	
//	==========================================================================
	
	// [방법 2] : MMR에도 접근이 가능함
//	MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//	MemberService memberService = new MemberService(memberRepository);
	
//	@AfterEach
//	void clear() {
//		memberRepository.clear();
//	}
	
//	==========================================================================
	
	// [방법 3]
	MemoryMemberRepository memberRepository;
	MemberService memberService;
	
	@BeforeEach
	void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	void clear() {
		memberRepository.clear();
	}
	
//	==========================================================================
	
	@Test
	void join() {
		// given : 어떤 데이터를 - Member 객체의 one 사용자
		Member member = new Member();
		member.setName("one");
		
		// when : 무엇을 검증할 것이냐 - 가입 여부
		Long saveId = memberService.join(member);
		
		// then : 검증 - 가입한 사용자 one == 저장된 사용자 one(객체 주소 비교)
		Member findMember = memberService.findOne(saveId).get();		// findOne 메소드 리턴 타입이 Optional => .get()
		assertThat(member).isEqualTo(findMember);
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
