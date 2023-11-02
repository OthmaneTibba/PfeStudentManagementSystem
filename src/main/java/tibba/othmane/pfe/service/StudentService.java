package tibba.othmane.pfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static tibba.othmane.pfe.utils.ErrorMessages.STUDENT_NOT_FOUND;
import tibba.othmane.pfe.customexception.students.StudentNotFoundException;
import tibba.othmane.pfe.dtos.student.CreateStudentDto;
import tibba.othmane.pfe.dtos.student.UpdateStudentDto;
import tibba.othmane.pfe.entity.Student;
import tibba.othmane.pfe.repository.StudentRepository;
import tibba.othmane.pfe.service.iservice.IStudentService;

@Service
public class StudentService implements IStudentService {

	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public ResponseEntity<Student> createStudent(CreateStudentDto studentDto) {
		Student student = Student.builder()
				.firstName(studentDto.getFirstName())
				.lastName(studentDto.getLastName())
				.groupe(studentDto.getGroupe())
				.branch(studentDto.getBranch())
				.email(studentDto.getEmail())
				.phoneNumber(studentDto.getPhoneNumber())
				.build();
		Student createdStudent = 	studentRepository.save(student);
		return ResponseEntity.ok(createdStudent);
	}

	@Override
	public ResponseEntity<List<Student>> findAll() {
		return ResponseEntity.ok(studentRepository.findAll());
	}

	@Override
	public ResponseEntity<Student> updateStudent(UpdateStudentDto studentDto) {
			Student student = studentRepository
					.findById(studentDto.getId())
					.orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND));
			student.setFirstName(studentDto.getFirstName());
			student.setLastName(studentDto.getLastName());
			student.setEmail(studentDto.getEmail());
			student.setBranch(studentDto.getBranch());
			student.setPhoneNumber(studentDto.getPhoneNumber());
			student.setGroupe(studentDto.getGroupe());
			studentRepository.save(student);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(student);
	}
	
	
	

	@Override
	public ResponseEntity<?> deleteStudent(int id) {
		Student student = studentRepository
				.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND));
		studentRepository.delete(student);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@Override
	public ResponseEntity<Student> findById(int id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND));
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(student);
	}

}
