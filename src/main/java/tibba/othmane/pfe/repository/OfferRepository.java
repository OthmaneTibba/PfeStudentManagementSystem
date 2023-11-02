package tibba.othmane.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tibba.othmane.pfe.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer>{

}
