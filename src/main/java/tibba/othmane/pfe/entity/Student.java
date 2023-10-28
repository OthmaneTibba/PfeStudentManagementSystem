package tibba.othmane.pfe.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private int groupe;
	private String branch;
	private String email;
	private String phoneNumber;
	@OneToOne
	private Pfe pfe;
	@ManyToMany
	@JoinTable(
			name = "Student_offers_table",
			joinColumns = {
					@JoinColumn(name = "student_id", referencedColumnName = "id")
					},
			inverseJoinColumns = {
					@JoinColumn(name = "offer_id", referencedColumnName = "id")
					}
			)
	private List<Offer> offers;	
}
