package com.example.jobFinder.services.position;

import com.example.jobFinder.models.dtos.CreatePositionDTO;
import com.example.jobFinder.models.dtos.PositionResponseDTO;
import com.example.jobFinder.models.dtos.SearchPositionDTO;

import java.util.List;

public interface PositionService {

  List<PositionResponseDTO> getAllPositions();

  PositionResponseDTO addNewPosition(String apiKey, CreatePositionDTO createPositionDTO);

  List<PositionResponseDTO> searchPositions(String apiKey, SearchPositionDTO searchPositionDTO);

  PositionResponseDTO findPosition(long positionId);
}
