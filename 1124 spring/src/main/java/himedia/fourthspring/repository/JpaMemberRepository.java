package himedia.fourthspring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import himedia.fourthspring.domain.Member;


//JPA				// @Transactional :
					// 단위 메소드가 실행을 하다가 문제가 생기면 Rollback(No commit)
//@Repository			// 원자성 : 어떠한 작업이 실행될 때 언제나 완전하게 진행되어 종료되거나,
@Transactional		// 그럴 수 없는 경우 실행을 하지 않는 경우를 말한다.
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
		// 여러 개의 row(객체) 리턴
//		List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
//							  .setParameter("name", name).getResultList();
		
		// 여러 개의 row(객체) 중 첫 번째 row(객체) 리턴
//		for(Member member : result) {
//			if(member.getName().equals(name))
//				return Optional.ofNullable(member);
//		}
//		return Optional.empty();
		
		// [하나의 row(객체) 리턴]
//		TypedQuery<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
//				  					.setParameter("name", name);
//		if((result.getParameterValue(name)).equals(name))
//			return Optional.ofNullable(result.getSingleResult());
//		return Optional.empty();
		
		Member result = em.createQuery("select m from Member m where m.name = :name", Member.class)
					.setParameter("name", name).getSingleResult();
		return Optional.ofNullable(result);
	}

	@Override
	public List<Member> findAll() {
		// [JPA] Query문에서 Table name을 입력할 때 첫 글자는 무조건 대문자로 써야함
		// member m => m : ALIAS(별칭) / ALIAS를 사용해야한다.
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}
	
}
