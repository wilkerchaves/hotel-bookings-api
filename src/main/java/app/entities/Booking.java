package app.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import app.dto.BookingRequestDto;
import app.enums.BookingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_bookings", uniqueConstraints = @UniqueConstraint(columnNames = {
		"payment_id" }, name = "payment_id_constraint"))
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	private String client;

	private LocalDateTime checkIn;
	private LocalDateTime checkOut;

	@ManyToOne
	@JoinColumn(name = "room_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "room_pk"))
	private Room room;

	@OneToOne
	@JoinColumn(name = "payment_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "payment_pk"), unique = true)
	private Payment payment;

	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "booking_status")
	private BookingStatus status;

	public Booking() {
	}

	public Booking(UUID id, String client, LocalDateTime checkIn, LocalDateTime checkOut, Room room, Payment payment,
			LocalDateTime createdAt) {
		this.id = id;
		this.client = client;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.room = room;
		this.payment = payment;
		this.createdAt = createdAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public static Booking getFromDto(BookingRequestDto dto) {
		var booking = new Booking();
		booking.setClient(dto.client());
		booking.setCheckIn(dto.checkIn());
		booking.setCheckOut(dto.checkOut());
		return booking;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

}
