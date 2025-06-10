package app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {

}
