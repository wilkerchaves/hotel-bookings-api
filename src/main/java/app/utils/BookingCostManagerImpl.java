package app.utils;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import app.entities.Booking;

public class BookingCostManagerImpl implements BookingCostManager {

	public BigDecimal calcTotal(Booking booking) {
		if (booking.getCheckIn() != null && booking.getCheckOut() != null) {
			var days = ChronoUnit.DAYS.between(booking.getCheckIn(), booking.getCheckOut());
			var total = booking
					.getRoom()
					.getPrice()
					.multiply(BigDecimal.valueOf(days));
			return total;
		}
		throw new RuntimeException("The checkin/checkout date not be null");
	}

}
