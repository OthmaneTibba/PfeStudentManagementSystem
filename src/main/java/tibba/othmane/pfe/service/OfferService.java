package tibba.othmane.pfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tibba.othmane.pfe.customexception.offer.OfferNotFoundException;
import tibba.othmane.pfe.dtos.offer.CreateOfferDto;
import tibba.othmane.pfe.dtos.offer.UpdateOfferDto;
import tibba.othmane.pfe.entity.Offer;
import tibba.othmane.pfe.repository.OfferRepository;
import tibba.othmane.pfe.service.iservice.IOfferService;

import static tibba.othmane.pfe.utils.ErrorMessages.OFFER_NOT_FOUND;


@Service
public class OfferService implements IOfferService {
	
	private final OfferRepository offerRepository;
	
	public OfferService(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	@Override
	public ResponseEntity<Offer> createOffer(CreateOfferDto offerDto) {
		Offer offer = Offer.builder()
				.company(offerDto.getCompany())
				.technology(offerDto.getTechnology())
				.status(offerDto.getStatus())
				.build();
		Offer newOffer = offerRepository.save(offer);			
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(newOffer);
	}

	@Override
	public ResponseEntity<List<Offer>> findAll() {
		return  ResponseEntity
				.status(HttpStatus.OK).
				body(offerRepository.findAll());
	}

	@Override
	public ResponseEntity<Offer> updateOffer(UpdateOfferDto offerDto) {
			Offer offer = offerRepository.findById(offerDto.getId())
			.orElseThrow(() -> new OfferNotFoundException(OFFER_NOT_FOUND));
		
			
			offer.setStatus(offerDto.getStatus());
			offer.setCompany(offerDto.getCompany());
			offer.setTechnology(offerDto.getTechnology());
			
		    Offer savedOffer = 	offerRepository.save(offer);
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(savedOffer);
	}

	@Override
	public ResponseEntity<?> deleteOffer(int id) {
		Offer offer = offerRepository.findById(id)
				.orElseThrow(() -> new OfferNotFoundException(OFFER_NOT_FOUND));
		offerRepository.delete(offer);
		return ResponseEntity.status(HttpStatus.OK)
				.body(null);
	}

}
