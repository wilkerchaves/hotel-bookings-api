package app.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import app.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@CreationTimestamp
	private LocalDateTime moment;
	
	@Enumerated(EnumType.STRING)
	private PaymentType type;
	
	private BigDecimal total;
	
	@OneToOne(mappedBy = "payment")
	private Booking booking;

	public Payment() {
	}

	public Payment(UUID id, LocalDateTime moment, String type, BigDecimal total) {
		this.id = id;
		this.moment = moment;
		this.type = PaymentType.convertToEnum(type);
		this.total = total;
	}

	public Payment(UUID id, LocalDateTime moment, int cod, BigDecimal total) {
		this.id = id;
		this.moment = moment;
		this.type = PaymentType.convertToEnum(cod);
		this.total = total;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
