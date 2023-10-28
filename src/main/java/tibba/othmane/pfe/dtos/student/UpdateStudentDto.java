package tibba.othmane.pfe.dtos.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor(staticName = "unique")
@NoArgsConstructor
@Data
public class UpdateStudentDto {
	@NotNull(message = "id should not be null")
	private int id;
	@NotNull(message = "firstName should not be null")
	private String firstName;
	@NotNull(message = "lastName should not be null")
	private String lastName;
	@NotNull(message = "group should not be null")
	private int groupe;
	@NotNull(message = "branch should not be null")
	private String branch;
	@Email(message = "the provided email is not a valid email format")
	@NotNull(message = "email should not be null")
	private String email;
	@NotNull(message = "phoneNumber should not be null")
	private String phoneNumber;
}
