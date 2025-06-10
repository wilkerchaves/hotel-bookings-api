package app.dto;

import app.entities.Room;

public record RoomResponseDto(String id, Integer number, String type, Float price, boolean isOccupied, boolean isActived) {
	
	public static RoomResponseDto getFromEntity(Room room) {
		return new RoomResponseDto(
				room.getId().toString(),
				room.getNumber(), 
				room.getType().getDesc(),
				room.getPrice().floatValue(),
				room.isOccupied(),
				room.isActived());
	}

}
