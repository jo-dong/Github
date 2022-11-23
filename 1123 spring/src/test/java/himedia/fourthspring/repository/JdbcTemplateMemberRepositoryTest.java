package himedia.fourthspring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import himedia.fourthspring.domain.Member;

@SpringBootTest
@Transactional
class JdbcTemplateMemberRepositoryTest {	// JUnit Test에서는 생성자를 통한 DI를 하면 안됨
											// field를 통한 DI를 해야함.
	@Autowired DataSource dataSource;
	@Autowired private JdbcTemplateMemberRepository repository;

	@Test
	void testSave() {
		// given
		Member member = new Member();
		member.setName("홍길동");
		// when
		Member saveId = repository.save(member);
		// then
		// assertThat(Test_Target).method()
		assertThat(saveId.getName()).isEqualTo(member.getName());
		
	}

	@Test
	void testFindById() {
		Member member = new Member();
		member.setName("홍길동");
		
		Member savedId = repository.save(member);
		
		Member result = repository.findById(savedId.getId()).get();
		
		// 1.
		assertThat(result).isNotNull();
//		assertThat(result).isNull();		// failure : {expected : null} -> {but was : ~~Member@5a3cf824}
		// 2.
		assertThat(result.getId()).isEqualTo(savedId.getId());
	}

	@Test
	void testFindByName() {
		Member member = new Member();
		member.setName("홍길동");
		
		Member savedMember = repository.save(member);
		
		Member result = repository.findByName(savedMember.getName()).get();
		
		// 1.
		assertThat(result.getName()).isEqualTo(savedMember.getName());
		// 2.
		assertThat(result).isNotNull();
	}

	@Test
	void testFindAll() {
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