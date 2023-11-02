package tibba.othmane.pfe.customexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tibba.othmane.pfe.customexception.offer.OfferNotFoundException;
import tibba.othmane.pfe.customexception.students.StudentNotFoundException;
import tibba.othmane.pfe.customexception.supervisor.SupervisorNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	private String errorCodeKey= "errorCode";
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> studnetInvalidArguments(MethodArgumentNotValidException e){
		HashMap<String, Object> errors = new HashMap<String,Object>();
		errors.put(errorCodeKey, HttpStatus.BAD_REQUEST.value());
		e.getBindingResult().getFieldErrors().forEach((error) -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
			
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> cannotFindStudent(StudentNotFoundException e){
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put(errorCodeKey, HttpStatus.NOT_FOUND.value());
		errorMap.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
	}
	
	
	@ExceptionHandler(SupervisorNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleSupervisorNotFound(SupervisorNotFoundException e){
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put(errorCodeKey, HttpStatus.NOT_FOUND.value());
		errorMap.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
	}
	
	
	@ExceptionHandler(OfferNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleOfferNotFound(OfferNotFoundException e){
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put(errorCodeKey, HttpStatus.NOT_FOUND.value());
		errorMap.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
	}
	
	
	
}
