package himedia.fifthspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import himedia.fifthspring.repository.MemberRepository;
import himedia.fifthspring.service.MemberService;

@Configuration
public class Config {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public Config(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

}
