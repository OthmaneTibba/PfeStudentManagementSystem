package tibba.othmane.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tibba.othmane.pfe.entity.Supervisor;


@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer>{

}
