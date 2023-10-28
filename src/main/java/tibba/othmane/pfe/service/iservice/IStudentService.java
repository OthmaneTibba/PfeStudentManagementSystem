package tibba.othmane.pfe.service.iservice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import tibba.othmane.pfe.dtos.student.CreateStudentDto;
import tibba.othmane.pfe.dtos.student.UpdateStudentDto;
import tibba.othmane.pfe.entity.Student;

public interface IStudentService {
	public ResponseEntity<Student> createStudent(CreateStudentDto studentDto);
	public ResponseEntity<List<Student>> findAll();
	public ResponseEntity<Student> updateStudent(UpdateStudentDto studentDto);
	public ResponseEntity<?> deleteStudent(int id);
}
