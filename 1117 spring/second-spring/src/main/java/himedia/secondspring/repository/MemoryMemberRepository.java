package himedia.secondspring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import himedia.secondspring.domain.Member;

// interface MemberRepository를 상속 / interface를 실제로 구현하는 부분

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
		Iterator<Entry<Long, Member>> iter = store.entrySet().iterator();
		Entry<Long, Member> nextMember = iter.next();
		while(iter.hasNext()) {
			if(name.equals(nextMember.getValue().getName())) 
				return Optional.of(nextMember.getValue());
		}
		return null;
	}

	// findAll 전체 정보 return
	@Override
	public List<Member> findAll() {
		List<Member> storeList = new ArrayList<>(store.values());
		return storeList;
	}

}
