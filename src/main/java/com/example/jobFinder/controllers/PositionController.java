package com.example.jobFinder.controllers;

import com.example.jobFinder.models.dtos.CreatePositionDTO;
import com.example.jobFinder.models.dtos.PositionResponseDTO;
import com.example.jobFinder.models.dtos.SearchPositionDTO;
import com.example.jobFinder.services.position.PositionService;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/position")
public class PositionController {

  private final PositionService positionService;

  @Autowired
  public PositionController(PositionService positionService) {
    this.positionService = positionService;
  }

  @Operation(summary = "Get all positions")
  @GetMapping("")
  public ResponseEntity<List<PositionResponseDTO>> getAllPositions() {
    List<PositionResponseDTO> positions = positionService.getAllPositions();
    return ResponseEntity.status(HttpStatus.OK).body(positions);
  }

  @Operation(summary = "Create new position")
  @PostMapping("")
  public ResponseEntity<PositionResponseDTO> createNewPosition(
      @RequestParam String apiKey, @RequestBody CreatePositionDTO createPositionDTO) {
    return ResponseEntity.status(201)
        .body(positionService.addNewPosition(apiKey, createPositionDTO));
  }

  @Operation(summary = "Search for specific position(s)")
  @PostMapping("/search")
  public ResponseEntity<List<PositionResponseDTO>> searchForPositions(
      @RequestParam String apiKey, @RequestBody SearchPositionDTO searchPositionDTO) {
    return ResponseEntity.status(200)
        .body(positionService.searchPositions(apiKey, searchPositionDTO));
  }

  @Operation(summary = "Get specific position by ID")
  @GetMapping("/{positionId}")
  public ResponseEntity<PositionResponseDTO> findPosition(@PathVariable Long positionId) {
    return ResponseEntity.status(200).body(positionService.findPosition(positionId));
  }
}
