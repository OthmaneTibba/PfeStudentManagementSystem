package tibba.othmane.pfe.service.iservice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import tibba.othmane.pfe.dtos.offer.CreateOfferDto;
import tibba.othmane.pfe.dtos.offer.UpdateOfferDto;
import tibba.othmane.pfe.entity.Offer;

public interface IOfferService {

	public ResponseEntity<Offer> createOffer(CreateOfferDto offerDto);
	
	public ResponseEntity<List<Offer>> findAll();
	
	public ResponseEntity<Offer> updateOffer(UpdateOfferDto offerDto);
	
	public ResponseEntity<?> deleteOffer(int id);
	
	
}
