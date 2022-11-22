package himedia.examspring.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.examspring.domain.Member;
import himedia.examspring.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceTest {
	
	@Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
	
	@Test
	void join() {
        Member member = new Member();
        member.setName("홍길동");

        Long saveId = memberService.join(member);
        
        Member findMember = memberService.idFindMember(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
	
	@Test
	void findAllMember() {
		Member member1 = new Member();
		member1.setName("홍길동");
		
		Member member2 = new Member();
		member2.setName("박보검");
		
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
		
		assertThat(member.getName()).isEqualTo(check.getName());
	}

}
