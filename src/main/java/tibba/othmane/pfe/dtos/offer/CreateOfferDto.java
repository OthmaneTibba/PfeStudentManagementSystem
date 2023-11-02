package tibba.othmane.pfe.dtos.offer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferDto {
	@NotNull(message = "company should not null")
	private String company;
	@NotNull(message = "technology should not be null")
	private String technology;
	@NotNull(message = "status should not be nul")
	private String status;
}
