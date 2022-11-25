package himedia.fifthspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import himedia.fifthspring.domain.Member;
																// Long = ID의 type 
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	
}
