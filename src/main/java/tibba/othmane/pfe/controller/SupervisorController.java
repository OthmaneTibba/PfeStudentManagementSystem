package tibba.othmane.pfe.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tibba.othmane.pfe.dtos.supervisor.CreateSupervisorDto;
import tibba.othmane.pfe.entity.Supervisor;
import tibba.othmane.pfe.service.iservice.ISupervisorService;

@RestController
@RequestMapping("/api/supervisors")
@CrossOrigin
public class SupervisorController {
	
	private final ISupervisorService supervisorService;
	
	
	public SupervisorController(ISupervisorService supervisorService) {
		this.supervisorService = supervisorService;
	}
	
	
	
	
	@GetMapping
	public ResponseEntity<List<Supervisor>> findAll(){
		return supervisorService.findAll();
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Supervisor> createSupervisor(CreateSupervisorDto supervisorDto){
		return supervisorService.createSupervisor(supervisorDto);
	}

}
