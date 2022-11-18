package himedia.secondspring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import himedia.secondspring.repository.JdbcMemberRepository;
import himedia.secondspring.repository.MemberRepository;
import himedia.secondspring.service.MemberService;

@Configuration		// Bean 생성을 한 방에 몰아서 관리하기 위한 Config 파일 / 설정과 관련 있음
public class Config {

	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	// 다형성
	@Bean		
	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
}
