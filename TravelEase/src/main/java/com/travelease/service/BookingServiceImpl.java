package com.travelease.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.BookingException;
import com.travelease.models.Booking;
import com.travelease.models.BookingDTO;
import com.travelease.models.BookingStatus;
import com.travelease.models.Customer;
import com.travelease.models.Packages;
import com.travelease.models.Session;
import com.travelease.models.TicketDetails;
import com.travelease.repository.BookingDAO;
import com.travelease.repository.BusDAO;
import com.travelease.repository.BusRepository;
import com.travelease.repository.CustomerDAO;
import com.travelease.repository.PackagesDAO;
import com.travelease.repository.TicketDetailsDAO;


@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDAO bookingDao;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private PackagesDAO packageDAO;

	@Autowired
	private TicketDetailsDAO ticketDetailsDao;

	@Autowired
	private BusRepository busDao;


	
	@Override
	public Booking makeBooking(BookingDTO bookingDTO, Session session) throws BookingException {

		Packages bookedPackage = packageDAO.findById(bookingDTO.getPackageId())
				.orElseThrow(() -> new BookingException("Invalid Package ID ! "));
		
		Customer currentCustomer = customerDAO.findById(session.getUserId())
				.orElseThrow(() -> new BookingException("Invalid Customer ID ! "));

		if (bookedPackage != null ) {

				// Creating New Booking
				Booking booking = new Booking();

				// Setting Booking Details
				booking.setBookingDate(LocalDateTime.now());
				booking.setBookingTitle(bookedPackage.getPackageName() + " " + bookedPackage.getPackageDescription());
				booking.setCustomer(currentCustomer);
				String bookingDescription = "Bus Number : " + bookedPackage.getBus().getBusNumber() + " - Bus Type : "
						+ bookedPackage.getBus().getBusType() + "- Seat Number : Will Be Alloted After Payment."
						+ " - Hotel Name : " + bookedPackage.getHotel().getHotelName();
				booking.setDescription(bookingDescription);
				booking.setBookingStatus(BookingStatus.PAYMENT_PENDING);
				booking.setPackages(bookedPackage);
				booking.setTotalCost(bookedPackage.getPackageCost() * bookingDTO.getNoOfPersons());
				booking.setNoOfPersons(bookingDTO.getNoOfPersons());

				// Creating a New Bus Ticket
				TicketDetails td = new TicketDetails();

				// Assigning Bus To The Ticket
				td.setBus(bookedPackage.getBus());

				// Storing The Ticket Inside the List of Tickets Of The Bus
				bookedPackage.getBus().getTicketdetails().add(td);

				// Updating the Bus To Database
				busDao.save(bookedPackage.getBus());

				// Assigning Ticket To The Booking
				booking.setTicket(td);

				// Updating Ticket Details To Database
				ticketDetailsDao.save(td);

				// Saving The Booking To Database
				return bookingDao.save(booking);
		} else
			throw new BookingException("Package And Customer Cannot Be Null !");
	}

	@Override
	public Booking cancelBookingById(Integer bookingId) throws BookingException {
		Booking currentBooking = bookingDao.findById(bookingId)
				.orElseThrow(() -> new BookingException("Bookings Not Found With Packages ID :" + bookingId));
		currentBooking.setBookingStatus(BookingStatus.CANCELLED);
		Packages cancelledPackage = currentBooking.getPackages();
		busDao.save(cancelledPackage.getBus());
		bookingDao.save(currentBooking);
		packageDAO.save(cancelledPackage);
		return currentBooking;
	}

	@Override
	public Booking ViewBookingById(Integer bookingId) throws BookingException {
		return bookingDao.findById(bookingId)
				.orElseThrow(() -> new BookingException("Bookings Not Found With Packages ID :" + bookingId));
	}

	@Override
	public List<Booking> viewAllBookings() throws BookingException {
		return bookingDao.findAll();
	}

	

}
