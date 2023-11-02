package tibba.othmane.pfe.dtos.supervisor;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSupervisorDto {
	@NotNull(message = "id should not be null")
	private int id;
	@NotNull(message = "firstName should not be null")
	private String firstName;
	@NotNull(message = "lastName should not be null")
	private String lastName;
	@NotNull(message = "speciality should not be null")
	private String speciality;
	@NotNull(message =  "type should not be null")
	private String type;
	@NotNull(message = "phoneNumber should not be null")
	private String phoneNumber;
}
