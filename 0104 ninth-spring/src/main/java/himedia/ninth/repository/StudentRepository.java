package himedia.ninth.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import himedia.ninth.domain.Student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
@Transactional
public class StudentRepository {
	
	private final EntityManager em;
	
	/**
	 * [저장]
	 * 
	 * @param student
	 */
	public void save(Student student) {
		em.persist(student);
	}
	
	/**
	 * [전체 조회] - 오름차순
	 * 
	 * @return Students' List(ASC)
	 */
	public List<Student> findAll() {
		return em.createQuery("select s from Student s", Student.class)
				.getResultList();
	}
	
	/**
	 * [전체 조회] - 내림차순
	 * 
	 * @return Students' List(DESC)
	 */
	public List<Student> findAllOrderByDesc() {
		return em.createQuery("select s from Student s order by s.id desc", Student.class)
				.getResultList();
	}
	
	/**
	 * [id로 조회]
	 * 
	 * @param id
	 * @return id에 해당하는 student
	 */
	public Student find(Long id) {
		return em.find(Student.class, id);
	}
	
	/**
	 * [수정]
	 * - 따로 EntityManager에 update method가 있지 않지만
	 * - setter를 이용하여 값 변경 -> hibernate가 자동으로 update 쿼리문 돌림
	 * 
	 * @param updateStudent
	 * @return updateStudent
	 */
	public Student update(Student updateStudent) {
		Student student = em.find(Student.class, updateStudent.getId());
		student.setName(updateStudent.getName());
		return student;
	}
	
	/**
	 * [삭제]
	 * - remove method의 parameter -> (Object entity)
	 * => 그냥 id를 넣는 것이 아닌 id로 조회한 객체 
	 *  즉, em.find(id)를 parameter로 넣어줌 
	 *  
	 * @param id
	 */
	public void delete(Long id) {
		em.remove(find(id));
	}
}
