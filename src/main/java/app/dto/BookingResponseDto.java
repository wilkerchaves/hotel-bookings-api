package app.dto;

import java.time.LocalDateTime;

public record BookingResponseDto(
		String id,
		String client,
		LocalDateTime checkIn,
		LocalDateTime checkOut,
		Integer room) {

}
