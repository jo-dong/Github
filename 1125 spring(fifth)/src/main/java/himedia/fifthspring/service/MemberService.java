package himedia.fifthspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.fifthspring.domain.Member;
import himedia.fifthspring.repository.MemberRepository;

//@Service
public class MemberService {

	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public Long join(Member member) {
		memberRepository.save(member);
		return member.getId();
	}
	
	public List<Member> findAllMembers() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> idFindMember(Long id) {
		return memberRepository.findById(id);
	}
	
	public Optional<Member> nameFindMember(String name) {
		return memberRepository.findByName(name);
	}
}
