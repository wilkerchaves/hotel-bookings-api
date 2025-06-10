package app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

}
