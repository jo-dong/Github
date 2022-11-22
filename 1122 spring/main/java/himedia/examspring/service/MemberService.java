package himedia.examspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import himedia.examspring.domain.Member;
import himedia.examspring.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public Long join(Member member) {
		memberRepository.save(member);
		return member.getId();
	}
	
	public List<Member> findAllMember() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> idFindMember(Long memberId) {
		return memberRepository.findById(memberId);
	}
	
	public Optional<Member> nameFindMember(String memberName) {
		return memberRepository.findByName(memberName);
	}
}