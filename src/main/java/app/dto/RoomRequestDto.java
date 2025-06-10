package app.dto;

import app.entities.Room;
import jakarta.validation.constraints.NotNull;

public record RoomRequestDto(
		@NotNull(message = "The number field not be null") 
		Integer number, 
		@NotNull(message = "The type field not be null") 
		String type, 
		@NotNull(message = "The isOccupied field not be null") 
		boolean isOccupied, 
		@NotNull(message = "The isActived field not be null") 
		boolean isActived) {

	public static RoomRequestDto getFromEntity(Room room) {
		return new RoomRequestDto(
				room.getNumber(), 
				room.getType().getDesc(),
				room.isOccupied(),
				room.isActived());
	}

}
