package app.utils;

import java.math.BigDecimal;

import app.entities.Booking;

public interface BookingCostManager {

	public BigDecimal calcTotal(Booking booking);
}
