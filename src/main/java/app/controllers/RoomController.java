package app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.RoomRequestDto;
import app.services.RoomService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	private final RoomService roomService;
	
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping
	public ResponseEntity<List<RoomRequestDto>> getAll() {
		return ResponseEntity.ok(this.roomService.getAllRooms());
	}
	
	@PostMapping
	public ResponseEntity<RoomRequestDto> save(@Valid RoomRequestDto dto) {
		return ResponseEntity.ok(this.roomService.save(dto));
		
	}

}
