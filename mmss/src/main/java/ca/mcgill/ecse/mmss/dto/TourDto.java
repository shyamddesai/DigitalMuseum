package ca.mcgill.ecse.mmss.dto;

import java.sql.Date;
import ca.mcgill.ecse.mmss.model.Tour;
import ca.mcgill.ecse.mmss.model.Tour.ShiftTime;

public class TourDto {
	private int bookingId;
	private double pricePerPerson;
	private int numberOfParticipants;
	private ShiftTime shiftTime;
	private String visitorUsername;
	private Date date;

	/**
	 * Null constructor
	 * 
	 * @author Shyam Desai
	 */
	public TourDto() {
	}

	/**
	 * Constructor that takes in a tour as an argument
	 * 
	 * @author Shyam Desai, Shidan Javaheri
	 * @param tour
	 */
	public TourDto(Tour tour) {
		this.bookingId = tour.getBookingId();
		this.pricePerPerson = tour.getPricePerPerson();
		this.numberOfParticipants = tour.getNumberOfParticipants();
		this.shiftTime = tour.getTourTime();
		this.visitorUsername = tour.getVisitor().getUsername();
		this.date = tour.getDate().getDate();
	}

	/**
	 * Constructor that takes in separate arguments
	 * 
	 * @author Shyam Desai, Shidan Javaheri
	 * @param bookingId
	 * @param pricePerPerson
	 * @param numberOfParticipants
	 * @param shiftTime
	 * @param visitorUsername
	 * @param date
	 */
	public TourDto(int bookingId, double pricePerPerson, int numberOfParticipants, ShiftTime shiftTime,
			String visitorUsername, Date date) {
		this.bookingId = bookingId;
		this.pricePerPerson = pricePerPerson;
		this.numberOfParticipants = numberOfParticipants;
		this.shiftTime = shiftTime;
		this.visitorUsername = visitorUsername;
		this.date = date;
	}

	public int getBookingId() {
		return bookingId;
	}

	public double getPricePerPerson() {
		return pricePerPerson;
	}

	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public ShiftTime getShiftTime() {
		return shiftTime;
	}

	public String getVisitorUsername() {
		return visitorUsername;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setVisitorUsername(String visitorUsername) {
		this.visitorUsername = visitorUsername;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setPricePerPerson(double pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}

	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public void setShiftTime(ShiftTime shiftTime) {
		this.shiftTime = shiftTime;
	}
}