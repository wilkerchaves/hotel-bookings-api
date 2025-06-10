package app.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import app.dto.RoomRequestDto;
import app.entities.Room;
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

	public RoomRequestDto save(RoomRequestDto dto) {
		var entity = Room.getFromRequestDto(dto);
		var saved = this.roomRepository.save(entity);
		return RoomRequestDto.getFromEntity(saved);
	}

	public RoomRequestDto toggleIsActive(UUID id, boolean active) {
		var entity = this.roomRepository.findById(id).orElseThrow(RuntimeException::new);
		entity.setActived(active);
		var saved = this.roomRepository.save(entity);
		return RoomRequestDto.getFromEntity(saved);
	}

	public RoomRequestDto toggleIsOccupied(UUID id, boolean occupied) {
		var entity = this.roomRepository.findById(id).orElseThrow(RuntimeException::new);
		entity.setOccupied(occupied);
		var saved = this.roomRepository.save(entity);
		return RoomRequestDto.getFromEntity(saved);
	}
}
