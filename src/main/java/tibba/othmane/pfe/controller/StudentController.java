package tibba.othmane.pfe.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tibba.othmane.pfe.dtos.student.CreateStudentDto;
import tibba.othmane.pfe.dtos.student.UpdateStudentDto;
import tibba.othmane.pfe.entity.Student;
import tibba.othmane.pfe.service.iservice.IStudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final IStudentService studentService;

	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> findAll(){
		return studentService.findAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody @Valid CreateStudentDto studentDto){
		return studentService.createStudent(studentDto);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody @Valid UpdateStudentDto studentDto){
		return studentService.updateStudent(studentDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable int id){
		return studentService.deleteStudent(id);
	}
	
	
}
