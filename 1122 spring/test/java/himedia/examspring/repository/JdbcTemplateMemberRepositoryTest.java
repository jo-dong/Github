package himedia.examspring.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.examspring.domain.Member;

@SpringBootTest
@Transactional
public class JdbcTemplateMemberRepositoryTest {
	
	@Autowired
	private JdbcTemplateMemberRepository repository;
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("홍길동");
		
		Member check = repository.save(member);
		
		assertEquals(member.getName(), check.getName());
	}
	
	@Test
	void findById() {
		Member member = new Member();
		member.setName("홍길동");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		
		assertEquals(member.getName(), result.getName());
	}
	
	@Test
	void findByName() {
		Member member = new Member();
		member.setName("홍길동");
		
		repository.save(member);
		
		Member result = repository.findByName(member.getName()).get();
		
		assertEquals(member.getName(), result.getName());
	}
	
	@Test
	void findAll() {
		Member member1 = new Member();
		member1.setName("홍길동");
		
		Member member2 = new Member();
		member2.setName("박보검");
		
		repository.save(member1);
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		assertThat(result.size()).isEqualTo(2);
	}
	
}
