package himedia.secondspring.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import himedia.secondspring.domain.Member;

public class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	// method 단위로 하는 Test 말고 통합 테스트를 진행하면 method 사이의 순서가 없다.
	// 순서가 필요한 테스트라면 테스트 한 개 진행하고 지우는 method를 추가해주면 됨
	// @AfterEach : Test1 -> @AfterEach 실행 -> Test2 -> @AfterEach -> Test3 -> ...
	
	@AfterEach
	void clearStore() {
		repository.clear();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		// 1. 검증(findById를 통하여) ------------------
		Member result = repository.findById(member.getId()).get();
		
		assertEquals(member, result);
		assertThat(member).isEqualTo(result);
		// 둘 중 아무거나 쓰기
	}
	
	@Test
	void findByName() {
		Member member = new Member();
		member.setName("one");
		repository.save(member);
		
		Member result = repository.findByName("one").get();		
		// Optional이 감싸져있어서 .get() 필요
		
		assertThat(result.getName()).isEqualTo("one");
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
