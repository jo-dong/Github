package himedia.fifthspring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.fifthspring.domain.Member;

@SpringBootTest
@Transactional
class JdbcTemplateMemberRepositoryTest {

	@Autowired DataSource dataSource;
	@Autowired private JdbcTemplateMemberRepository repo;
	
	@Test
	void save() {
		Member member = new Member();
		member.setName("January");
		
		Member result = repo.save(member);
		
		assertThat(result.getName()).isEqualTo(member.getName());
	}
	
	@Test
	void findById() {
		Member member = new Member();
		member.setName("Feburary");
		repo.save(member);
		
		Long id = member.getId();
		Member result = repo.findById(id).get();
		
//		assertThat(result).isNotNull();
		assertThat(result.getId()).isEqualTo(id);
	}
	
	@Test
	void findByName() {
		Member member = new Member();
		member.setName("March");
		repo.save(member);

		String name = member.getName();
		Member result = repo.findByName(name).get();
		
//		assertThat(result).isNotNull();
		assertThat(result.getName()).isEqualTo(name);
	}
	
	@Test
	void findAll() {
		List<Member> beforeResult = repo.findAll();
		
		Member member1 = new Member();
		member1.setName("April");
		repo.save(member1);
		
		Member member2 = new Member();
		member2.setName("May");
		repo.save(member2);
		
		List<Member> afterResult = repo.findAll();
		
		assertThat(afterResult.size()).isEqualTo(beforeResult.size() + 2);
	}

}
