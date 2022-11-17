package himedia.secondspring.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import himedia.secondspring.domain.Member;

public class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		// 1. 검증(findById를 통하여) ------------------
		Member result = repository.findById(member.getId()).get();
		
		assertEquals(member, result);
		assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		// 2. 검증(findByName를 통하여) ------------------
		Member result = repository.findByName(member.getName()).get();
		
		assertEquals(member, result);
		assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("one");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("two");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		assertThat(result.size()).isEqualTo(2);
	}
	
}
