package app.enums;

import java.util.stream.Stream;

import app.exceptions.InvalidEnumArgumentException;

public enum RoomType {

	VENTILADOR(1, "Ventilador"), AR_CONDICIONADO(2, "Ar");

	private final int cod;
	private final String desc;

	private RoomType(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static RoomType convertToEnum(int cod) {
		return Stream.of(RoomType.values()).filter(type -> type.cod == cod).findFirst()
				.orElseThrow(() -> new InvalidEnumArgumentException(
						String.format("The value %d is not valid to be a room type.", cod)));
	}

	public static RoomType convertToEnum(String desc) {
		return Stream.of(RoomType.values()).filter(type -> type.desc.equalsIgnoreCase(desc)).findFirst()
				.orElseThrow(() -> new InvalidEnumArgumentException(
						String.format("The value %s is not valid to be a room type.", desc)));
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
