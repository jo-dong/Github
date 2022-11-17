package himedia.secondspring.repository;

import java.util.List;
import java.util.Optional;

import himedia.secondspring.domain.Member;

// DAO - interface : MemberRepository

public interface MemberRepository {

	// 1. 저장소에 저장
	Member save(Member member);
	
	// 2. 저장된 id, name으로 검색
	// import java.util.Optional;
	// NullPointerException을 방지하기 위해 Optional로 처리
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	
	// 3. 저장된 모든 회원 정보 return
	List<Member> findAll();			
	
	/*
	 * [Wrapper Class]
	 *  long - Long
	 *  int - Integer의 관계에서 Integer가 wrapper class
	 *  null의 wrapper class = Optional
	 */
	
}
