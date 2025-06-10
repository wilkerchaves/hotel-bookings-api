package app.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record BookingRequestDto(
		@NotBlank(message = "The client field not be blank")
		String client,
		@NotBlank(message = "The checkin field not be blank")
		LocalDateTime checkIn,
		
		LocalDateTime checkOut,
		@NotBlank(message = "The room field not be blank")
		Integer room) {

}
