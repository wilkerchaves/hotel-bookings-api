package app.entities;

import java.util.UUID;

import app.dto.RoomRequestDto;
import app.enums.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "room_number")
	private Integer number;

	@Enumerated(EnumType.STRING)
	@Column(name = "room_type")
	private RoomType type;

	private boolean isOccupied;
	private boolean isActived;

	public Room() {

	}

	public Room(UUID id, Integer number, String type, boolean isOccupied, boolean isActived) {
		this.id = id;
		this.number = number;
		this.type = RoomType.convertToEnum(type);
		this.isOccupied = isOccupied;
		this.isActived = isActived;
	}

	public Room(UUID id, Integer number, int cod, boolean isOccupied, boolean isActived) {
		this.id = id;
		this.number = number;
		this.type = RoomType.convertToEnum(cod);
		this.isOccupied = isOccupied;
		this.isActived = isActived;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean isActived() {
		return isActived;
	}

	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}

	public static Room getFromRequestDto(RoomRequestDto dto) {
		return new Room(null, dto.number(), dto.type(), dto.isOccupied(), dto.isActived());
	}

}
