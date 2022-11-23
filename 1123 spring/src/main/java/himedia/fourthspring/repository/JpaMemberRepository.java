package himedia.fourthspring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import himedia.fourthspring.domain.Member;

// JPA
@Repository
@Transactional
public class JpaMemberRepository implements MemberRepository {

	private final EntityManager em;
	
	// DI
	@Autowired
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Member save(Member member) {
		em.persist(member);
		System.out.println("[JPA] save : 실행 완료");
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// find는 Entity class의 Generic type을 Return
		// id는 key이기 때문에 간단한 find method를 통해 가능
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
//		TypedQuery<Member> typedQuery = em.createQuery("select * from member m where m.name = :name", Member.class);
//		TypedQuery<Member> typedQuery2 = typedQuery.setParameter("name", name);		// :name에 name 넣기
//		List<Member> result = typedQuery2.getResultList();
		// 위의 3줄을 한방에
		List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
							  .setParameter("name", name).getResultList();
		for(Member member : result) {
			if(member.getName().equals(name))
				return Optional.ofNullable(member);
		}
		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		// [JPA] Query문에서 Table name을 입력할 때 첫 글자는 무조건 대문자로 써야함
		// member m => m : ALIAS(별칭) / ALIAS를 사용해야한다.
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}
	
}
