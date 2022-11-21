package himedia.secondspring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import himedia.secondspring.domain.Member;

// interface MemberRepository를 상속 / interface를 실제로 구현하는 부분

//@Repository		// Repository Layer : @Repository	- 의존성 주입을 위한 Bean 생성 (Spring Boot 실행 시)
public class MemoryMemberRepository implements MemberRepository {

	// Collection Framework (member 관리)
	// <Long, Member> => id와 멤버로 관리
	private static Map<Long, Member> store = new HashMap<>();
	
	// id는 겹치면 안됨, 자동 생성
	private static long sequence = 0L;
	
	// save : store에 저장
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return null;
	}

	// findById : id를 찾아서 return
	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}
	
	// findByName : name을 찾아서 return
	@Override
	public Optional<Member> findByName(String name) {
		// 강사님 답
		for(Member m : store.values()) {
			if(m.getName().equals(name))
				return Optional.ofNullable(m);
		}
		return Optional.empty();
	}

	// findAll 전체 정보 return
	@Override
	public List<Member> findAll() {
		List<Member> storeList = new ArrayList<>(store.values());
		return storeList;
	}
	
	// 테스트를 위해 지우는 method 추가
	public void clear() {
		store.clear();
	}
	

}
