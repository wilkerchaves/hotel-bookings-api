package app.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.dto.RoomRequestDto;
import app.dto.RoomResponseDto;
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
	public ResponseEntity<RoomResponseDto> save(@Valid @RequestBody RoomRequestDto dto) {
		return new ResponseEntity<RoomResponseDto>(this.roomService.save(dto), HttpStatus.CREATED);

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<RoomResponseDto> update(@RequestParam Float price, @PathVariable UUID id) {
		if(id == null) {
			throw new RuntimeException("id not be null");
		}
		var updatedRoom = this.roomService.updateRoom(price, id);
		return new ResponseEntity<RoomResponseDto>(updatedRoom, HttpStatus.OK);
	}

}
