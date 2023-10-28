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
			Optional<Student> student = studentRepository.findById(studentDto.getId());
			if(!student.isPresent())
				throw new StudentNotFoundException(STUDENT_NOT_FOUND);
			student.get().setFirstName(studentDto.getFirstName());
			student.get().setLastName(studentDto.getLastName());
			student.get().setEmail(studentDto.getEmail());
			student.get().setBranch(studentDto.getBranch());
			student.get().setPhoneNumber(studentDto.getPhoneNumber());
			student.get().setGroupe(studentDto.getGroupe());
			studentRepository.save(student.get());
			return ResponseEntity.status(HttpStatus.OK).body(student.get());
	}

	@Override
	public ResponseEntity<?> deleteStudent(int id) {
		Optional<Student> student = studentRepository.findById(id);
		if(!student.isPresent())
			throw new StudentNotFoundException(STUDENT_NOT_FOUND);
		studentRepository.delete(student.get());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
