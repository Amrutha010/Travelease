package com.travelease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.PaymentException;
import com.travelease.models.Booking;
import com.travelease.models.BookingStatus;
import com.travelease.models.Packages;
import com.travelease.models.Payment;
import com.travelease.models.PaymentDTO;
import com.travelease.models.PaymentStatus;
import com.travelease.models.Session;
import com.travelease.repository.BookingDAO;
import com.travelease.repository.BusDAO;
import com.travelease.repository.BusRepository;
import com.travelease.repository.PackagesDAO;
import com.travelease.repository.PaymentDAO;


@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDAO paymentDAO;

	@Autowired
	BookingDAO bookingDao;

	@Autowired
	PackagesDAO packageDAO;

	@Autowired
	BusRepository busDao;

	@Override
	public Payment makePayment(PaymentDTO paymentDTO, Session session) throws PaymentException {

		Booking currentBooking = bookingDao.findById(paymentDTO.getBookingId()).orElseThrow(() -> new PaymentException(
				"Payment Cannot Be Done For Inavalid Booking ID : " + paymentDTO.getBookingId()));
		Packages bookedPackage = packageDAO.findById(currentBooking.getPackages().getPackageId()).orElseThrow();

		Payment newPayment = new Payment();

		String correctUpiId = currentBooking.getCustomer().getCustomerName() +"@upi";
		
		if (paymentDTO.getUpi_Id().equals(correctUpiId) && paymentDTO.getPin() == 123456
				&& currentBooking.getBookingStatus() == BookingStatus.PAYMENT_PENDING
				&& currentBooking.getCustomer().getCustomerId() == session.getUserId()) {

			newPayment.setBooking(currentBooking);
			newPayment.setPaymentStatus(PaymentStatus.SUCCESSFULL);
			newPayment.setPaymentInfo("Mode of Payment : UPI |" + "UPI ID : " + paymentDTO.getUpi_Id());
			newPayment.setPaymentAmount(currentBooking.getTotalCost());

			currentBooking.setBookingStatus(BookingStatus.BOOKING_CONFIRMED);
			int seatNo = bookedPackage.getBus().getCapacity() - bookedPackage.getBus().getAvailable_seats() + 1;
			String bookingDescription = "Bus Number : " + bookedPackage.getBus().getBusNumber() + "\n Bus Type : "
					+ bookedPackage.getBus().getBusType() + "\n Seat Number : " + seatNo + "\n Hotel Name : "
					+ bookedPackage.getHotel().getHotelName();
			currentBooking.setDescription(bookingDescription);

			packageDAO.save(bookedPackage);
			busDao.save(bookedPackage.getBus());
			bookingDao.save(currentBooking);

			return paymentDAO.save(newPayment) ;
		} else {
			newPayment.setBooking(currentBooking);
			newPayment.setPaymentStatus(PaymentStatus.FAILED);

			if (currentBooking.getBookingStatus() == BookingStatus.BOOKING_CONFIRMED) {
				newPayment.setPaymentInfo("Payment for This Booking has Already been Done !!");
			} else {
				newPayment.setPaymentInfo("Payment Failed Due To Wrong/Invalid Credentials !!");
			}

			newPayment.setPaymentAmount(0.00);

			return newPayment;
		}

	}


	@Override
	public List<Payment> viewAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

}
