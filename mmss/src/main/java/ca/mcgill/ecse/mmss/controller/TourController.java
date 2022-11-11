package ca.mcgill.ecse.mmss.controller;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.ecse.mmss.dto.TourDto;
import ca.mcgill.ecse.mmss.model.Tour;
import ca.mcgill.ecse.mmss.model.Tour.ShiftTime;
import ca.mcgill.ecse.mmss.service.TourService;

@RestController
@RequestMapping("/tour")
public class TourController {

	@Autowired
	TourService tourService;

	/**
	 * Get tour by its Id
	 * 
	 * @param id
	 * @return response entity with tour and ok status
	 * @author Shyam Desai
	 */
	@GetMapping("/{tour}")
	public ResponseEntity<TourDto> getTour(@PathVariable int id) {
		Tour retrievedTour = tourService.retrieveTourById(id);
		return new ResponseEntity<TourDto>(new TourDto(retrievedTour), HttpStatus.OK);
	}

	/**
	 * Create tour
	 * 
	 * @param request
	 * @return tour as Dto in response entity with ok status
	 * @author Shyam Desai
	 */
	@PostMapping
	public ResponseEntity<TourDto> createTour(@RequestBody TourDto request) {
		String visitorUsername = request.getVisitorUsername();
		Date date = request.getDate();
		int numberOfParticipants = request.getNumberOfParticipants();
		ShiftTime shiftTime = request.getShiftTime();

		Tour persistedTour = tourService.createTour(visitorUsername, date, numberOfParticipants, shiftTime);
		return new ResponseEntity<TourDto>(new TourDto(persistedTour), HttpStatus.CREATED);
	}

	/**
	 * Update tour's date and number of participants
	 * 
	 * @param request
	 * @return updated Tour Dto in response entity with ok status
	 * @author Shyam Desai
	 */
	@PutMapping
	public ResponseEntity<TourDto> updateTourStatus(@RequestBody TourDto request) {
		int tourId = request.getBookingId();
		Date date = request.getDate();
		int numberOfParticipants = request.getNumberOfParticipants();

		Tour updatedTour = tourService.updateTour(tourId, date, numberOfParticipants);

		return new ResponseEntity<TourDto>(new TourDto(updatedTour), HttpStatus.OK);
	}

	/**
	 * Delete tour given its Id
	 * 
	 * @param request
	 * @return message indicating tour deleted
	 * @author Shyam Desai
	 */
	@DeleteMapping
	public ResponseEntity<String> deleteTour(@PathVariable int id) {
		tourService.deleteTour(id);

		return new ResponseEntity<String>("Tour succesfully deleted.", HttpStatus.OK);
	}

	// MAPPING OF OTHER GET METHODS

	/**
	 * Get ArrayList of all tours as Dtos
	 * 
	 * @return ArrayList of tours
	 * @author Shyam Desai
	 */
	@GetMapping("/getall")
	public ResponseEntity<ArrayList<TourDto>> getAllTours() {
		ArrayList<Tour> retrievedTours = tourService.getAllTours();

		ArrayList<TourDto> allToursDto = new ArrayList<>();
		for (Tour tour : retrievedTours) {
			allToursDto.add(new TourDto(tour));
		}

		return new ResponseEntity<ArrayList<TourDto>>(allToursDto, HttpStatus.OK);
	}
}