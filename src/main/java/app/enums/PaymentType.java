package app.enums;

import java.util.stream.Stream;

public enum PaymentType {

	PIX(10, "Pix"), DINHEIRO(20, "Dinheiro"), DEBITO(30, "Débito"), CREDITO(40, "Crédito");

	private final int cod;
	private final String desc;

	private PaymentType(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public static PaymentType convertToEnum(int cod) {
		return Stream.
				of(PaymentType.values())
				.filter(type -> type.cod == cod)
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public static PaymentType convertToEnum(String desc) {
		return Stream.
				of(PaymentType.values())
				.filter(type -> type.desc.equalsIgnoreCase(desc))
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}
}
