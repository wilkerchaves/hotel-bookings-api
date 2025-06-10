package app.enums;

import java.math.BigDecimal;
import java.util.stream.Stream;

public enum RoomType {

	VENTILADOR(1, "Ventilador") {
		@Override
		public BigDecimal getPrice() {
			
			return BigDecimal.valueOf(70);
		}
	},
	AR_CONDICIONADO(2, "Ar") {
		@Override
		public BigDecimal getPrice() {
			
			return BigDecimal.valueOf(100);
		}
	};

	private final int cod;
	private final String desc;

	private RoomType(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static RoomType convertToEnum(int cod) {
		return Stream.of(RoomType.values()).filter(type -> type.cod == cod).findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public static RoomType convertToEnum(String desc) {
		return Stream.of(RoomType.values()).filter(type -> type.desc.equalsIgnoreCase(desc)).findFirst()
				.orElseThrow(RuntimeException::new);
	}
	
	

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public abstract BigDecimal getPrice();

}
