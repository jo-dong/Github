package himedia.secondspring.service;

import java.util.List;
import java.util.Optional;

import himedia.secondspring.domain.Member;
import himedia.secondspring.repository.MemberRepository;

//@Service	// DI를 위한 Bean 생성 Annotation(Service Layer / Spring Boot 실행 시)
public class MemberService {
	
//	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final MemberRepository memberRepository;
	
	// final field의 초기화 -> 생성자를 통해 다형성 구현
//	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	/**
	 *  1. 회원 가입
	 */
	public Long join(Member member) {
		memberRepository.save(member);
		return member.getId();
	}
	
	/**
	 *  2. 전체 회원 조회
	 */
	public List<Member> findMember() {
		return memberRepository.findAll();
	}
	
	/**
	 *  3. id로 회원 조회
	 */
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
	
	/**
	 *  4. 이름으로 회원 조회
	 */
	public Optional<Member> findTwo(String memberName) {
		return memberRepository.findByName(memberName);
	}
	
}
