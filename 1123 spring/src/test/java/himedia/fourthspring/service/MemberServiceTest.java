package himedia.fourthspring.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.fourthspring.domain.Member;
import himedia.fourthspring.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceTest {
	
	@Autowired MemberRepository memberRepository;
	@Autowired MemberService memberService;
	
	@Test
	void join() {
        Member member = new Member();
        member.setName("spring");

        Long saveId = memberService.join(member);
        
        Member findMember = memberService.idFindMember(saveId).get();
        
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }
	
	@Test
	void findAllMember() {
		Member member1 = new Member();
		member1.setName("summer");
		
		Member member2 = new Member();
		member2.setName("winter");
		
		memberService.join(member1);
		memberService.join(member2);
		
		List<Member> check = memberService.findAllMember();
		
		assertThat(check.size()).isEqualTo(2);
	}
	
	@Test
	void idFindMember() {
		Member member = new Member();
		member.setName("홍길동");
		
		Long id = memberService.join(member);
		
		Member check = memberService.idFindMember(id).get();
		
		assertThat(check.getId()).isEqualTo(id);
	}
	
	@Test
	void nameFindMember() {
		Member member = new Member();
		member.setName("박보검");
		
		memberService.join(member);
		
		Member check = memberService.nameFindMember("박보검").get();
		
		assertThat(check.getName()).isEqualTo("박보검");
	}

}
