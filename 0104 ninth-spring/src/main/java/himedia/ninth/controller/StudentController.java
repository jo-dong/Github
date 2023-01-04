package himedia.ninth.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import himedia.ninth.domain.Student;
import himedia.ninth.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentRepository repository;
	
	@GetMapping("/hi")
	public Student index() {
		Student student = new Student("홍길동");
		repository.save(student);
		return student;
	}
	
	@GetMapping("/all")
	public List<Student> all() {
		return repository.findAll();
	}
	
	@GetMapping("/all-desc")
	public List<Student> allDesc() {
		return repository.findAllOrderByDesc();
	}
	
	@GetMapping("/find/{id}")
	public Student findOne(@PathVariable Long id) {
		return repository.find(id);
	}
	
	@GetMapping("/update")
	public Student updateName() {
		Student updatedStudent = new Student(1l, "이미자");
		return repository.update(updatedStudent);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		repository.delete(id);
		return id  + "번 학생 정보가 삭제되었습니다.";
	}
}
