package app.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID>{
	
	Optional<Room> findByNumber(Integer number);

}
