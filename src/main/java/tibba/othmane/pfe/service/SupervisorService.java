package tibba.othmane.pfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tibba.othmane.pfe.customexception.supervisor.SupervisorNotFoundException;
import tibba.othmane.pfe.dtos.supervisor.CreateSupervisorDto;
import tibba.othmane.pfe.dtos.supervisor.UpdateSupervisorDto;
import tibba.othmane.pfe.entity.Student;
import tibba.othmane.pfe.entity.Supervisor;
import tibba.othmane.pfe.repository.SupervisorRepository;
import tibba.othmane.pfe.service.iservice.ISupervisorService;
import static tibba.othmane.pfe.utils.ErrorMessages.SUPERVISOR_NOT_FOUND;



@Service
public class SupervisorService implements ISupervisorService {

	private final SupervisorRepository  supervisorRepository;
	
	public SupervisorService(SupervisorRepository supervisorRepository) {
		this.supervisorRepository = supervisorRepository;
	}
	
	@Override
	public ResponseEntity<Supervisor> createSupervisor(CreateSupervisorDto supervisorDto) {
			Supervisor supervisor = Supervisor.builder()
					.firstName(supervisorDto.getFirstName())
					.lastName(supervisorDto.getLastName())
					.phoneNumber(supervisorDto.getPhoneNumber())
					.speciality(supervisorDto.getSpeciality())
					.type(supervisorDto.getType())
					.build();
		Supervisor createdSupervisor = 	supervisorRepository.save(supervisor);
		return ResponseEntity.
				status(HttpStatus.CREATED)
				.body(createdSupervisor);
	}
	
	@Override
	public ResponseEntity<List<Supervisor>> findAll() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(supervisorRepository.findAll());
	}

	@Override
	public ResponseEntity<Supervisor> updateSupervisor(UpdateSupervisorDto supervisorDto) {
		Optional<Supervisor> supervisor = supervisorRepository.findById(supervisorDto.getId());
		if(!supervisor.isPresent())
			throw new SupervisorNotFoundException(SUPERVISOR_NOT_FOUND);
		supervisor.get().setFirstName(supervisorDto.getFirstName());
		supervisor.get().setLastName(supervisorDto.getLastName());
		supervisor.get().setPhoneNumber(supervisorDto.getPhoneNumber());
		supervisor.get().setSpeciality(supervisorDto.getSpeciality());
		supervisor.get().setType(supervisorDto.getType());
		supervisorRepository.save(supervisor.get());
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(supervisor.get());
	}

	@Override
	public ResponseEntity<?> deleteSupervisor(int id) {
		Optional<Supervisor> supervisor = supervisorRepository.findById(id);
		if(!supervisor.isPresent())
			throw new SupervisorNotFoundException(SUPERVISOR_NOT_FOUND);
		supervisorRepository.delete(supervisor.get());
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
