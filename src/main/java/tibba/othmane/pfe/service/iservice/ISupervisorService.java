package tibba.othmane.pfe.service.iservice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import tibba.othmane.pfe.dtos.supervisor.CreateSupervisorDto;
import tibba.othmane.pfe.dtos.supervisor.UpdateSupervisorDto;
import tibba.othmane.pfe.entity.Supervisor;

public interface ISupervisorService {
	public ResponseEntity<Supervisor> createSupervisor(CreateSupervisorDto supervisorDto);
	public ResponseEntity<List<Supervisor>> findAll();
	public ResponseEntity<Supervisor> updateSupervisor(UpdateSupervisorDto supervisorDto);
	public ResponseEntity<?> deleteSupervisor(int id);
}
