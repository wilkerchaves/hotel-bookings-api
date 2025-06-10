package app.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import app.dto.BookingResponseDto;
import app.dto.RoomRequestDto;
import app.dto.RoomResponseDto;
import app.entities.Room;
import app.exceptions.ResourceAlreadyExistsException;
import app.exceptions.ResourceNotFound;
import app.repositories.RoomRepository;

@Service
public class RoomService {

	private final RoomRepository roomRepository;

	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	public List<RoomRequestDto> getAllRooms() {
		return this.roomRepository.findAll().stream().map(RoomRequestDto::getFromEntity).toList();
	}

	public RoomResponseDto save(RoomRequestDto dto) {
		var duplicated = this.roomRepository.findByNumber(dto.number());
		if (duplicated.isPresent()) {
			throw new ResourceAlreadyExistsException(String
					.format("Already exists a resource with the same attributes: (room number %d)", dto.number()));
		}
		var entity = Room.getFromRequestDto(dto);
		var saved = this.roomRepository.save(entity);
		return RoomResponseDto.getFromEntity(saved);
	}

	public RoomRequestDto toggleIsActive(UUID id, boolean isActive) {
		var entity = this.roomRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound(String.format("The room with id %s not found", id.toString())));
		if (isActive != entity.isActived()) {
			entity.setActived(isActive);
			var saved = this.roomRepository.save(entity);
			return RoomRequestDto.getFromEntity(saved);
		}
		return RoomRequestDto.getFromEntity(entity);
	}

	public RoomRequestDto toggleIsOccupied(BookingResponseDto bookingDto, UUID id) {

		return null;
	}

	public RoomResponseDto updateRoom(Float price, UUID id) {
		var entity = this.roomRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound(String.format("The room with id %s not found", id.toString())));
		if (!entity.getPrice().equals(BigDecimal.valueOf(price))) {
			entity.setPrice(BigDecimal.valueOf(price));
			var saved = this.roomRepository.save(entity);
			return RoomResponseDto.getFromEntity(saved);
		}
		return RoomResponseDto.getFromEntity(entity);
	}
}
