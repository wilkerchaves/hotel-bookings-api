package app.enums;

import java.util.stream.Stream;

import app.exceptions.InvalidEnumArgumentException;

public enum BookingStatus {

	FINALIZADA(10, ""), ABERTA(20, ""), CANCELADA(30, "");

	private final int cod;
	private final String desc;

	private BookingStatus(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public int getCod() {
		return cod;
	}
	
	public static BookingStatus convertToEnum(int cod) {
		return Stream.
				of(BookingStatus.values())
				.filter(type -> type.cod == cod)
				.findFirst()
				.orElseThrow(()-> new InvalidEnumArgumentException(String.format("The value %d is not valid to be a booking status.", cod)));
	}

	public static BookingStatus convertToEnum(String desc) {
		return Stream.
				of(BookingStatus.values())
				.filter(type -> type.desc.equalsIgnoreCase(desc))
				.findFirst()
				.orElseThrow(()-> new InvalidEnumArgumentException(String.format("The value %s is not valid to be a booking status.", desc)));
	}

}
