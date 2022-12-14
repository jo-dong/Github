package himedia.fourthspring.repository;

import java.util.List;
import java.util.Optional;

import himedia.fourthspring.domain.Member;
// 2. Repository Interface
public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
