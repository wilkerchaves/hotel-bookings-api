package app.services;

import org.springframework.stereotype.Service;

import app.dto.BookingRequestDto;
import app.entities.Booking;
import app.repositories.BookingRepository;
import app.repositories.RoomRepository;

@Service
public class BookingService {

	private final BookingRepository bookingRepository;
	private final RoomRepository roomRepository;

	public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
		this.bookingRepository = bookingRepository;
		this.roomRepository = roomRepository;
	}

	public Booking createBooking(BookingRequestDto dto) {
		var booking = Booking.getFromDto(dto);
		var room = this.roomRepository.findByNumber(dto.room()).orElseThrow(RuntimeException::new);
		booking.setRoom(room);
		return this.bookingRepository.save(booking);

	}

}
