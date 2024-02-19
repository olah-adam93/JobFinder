package com.example.jobFinder.services.position;

import com.example.jobFinder.exceptions.*;
import com.example.jobFinder.mappers.PositionMapper;
import com.example.jobFinder.models.Position;
import com.example.jobFinder.models.dtos.CreatePositionDTO;
import com.example.jobFinder.models.dtos.PositionResponseDTO;
import com.example.jobFinder.models.dtos.SearchPositionDTO;
import com.example.jobFinder.repositories.ClientRepository;
import com.example.jobFinder.repositories.PositionRepository;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

  private final PositionRepository positionRepository;
  private final PositionMapper positionMapper;
  private final ClientRepository clientRepository;

  @Autowired
  public PositionServiceImpl(
      PositionRepository positionRepository,
      PositionMapper positionMapper,
      ClientRepository clientRepository) {
    this.positionRepository = positionRepository;
    this.positionMapper = positionMapper;
    this.clientRepository = clientRepository;
  }

  @Override
  public List<PositionResponseDTO> getAllPositions() {

    List<Position> positions = positionRepository.findAll();
    return positionMapper.positionsToDTOs(positions);
  }

  @Override
  public PositionResponseDTO addNewPosition(String apiKey, CreatePositionDTO createPositionDTO) {
    validateApiKey(apiKey);

    String positionName = createPositionDTO.getPositionName();
    String positionLocation = createPositionDTO.getLocation();

    validatePositionName(positionName);
    validatePositionLocation(positionLocation);

    Position newPosition =
        new Position(
            positionName.replace(" ", "_").toLowerCase(),
            positionLocation.replace(" ", "_").toLowerCase());

    newPosition = positionRepository.save(newPosition);
    URL url;
    try {
      url =
          new URL(
              String.format(
                  "https://indeed.com/%s/%s/%s",
                  newPosition.getLocation(), newPosition.getPositionName(), newPosition.getId()));
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
    newPosition.setUrl(String.valueOf(url));
    positionRepository.save(newPosition);
    return new PositionResponseDTO(url);
  }

  @Override
  public List<PositionResponseDTO> searchPositions(
      String apiKey, SearchPositionDTO searchPositionDTO) {
    validateApiKey(apiKey);

    String positionLocation = searchPositionDTO.getLocation();
    String keyWord = searchPositionDTO.getKeyWord();

    validatePositionLocation(positionLocation);
    validateKeyWord(keyWord);

    List<Position> positions =
        positionRepository.findAllByLocationAndKeyWord(positionLocation, keyWord);

    return positionMapper.positionsToDTOs(positions);
  }

  @Override
  public PositionResponseDTO findPosition(long positionId) {
    Position position =
        positionRepository
            .findById(positionId)
            .orElseThrow(() -> new PositionNotFoundException(positionId));
    return positionMapper.positionToDTO(position);
  }

  private void validatePositionName(String positionName) {
    if (positionName == null || positionName.isEmpty() || positionName.isBlank()) {
      throw new InvalidNameException("Position name cannot be empty or null.");
    }

    if (positionName.length() > 50) {
      throw new InvalidNameException("Position name cannot exceed 50 characters.");
    }
  }

  private void validatePositionLocation(String positionLocation) {
    if (positionLocation == null || positionLocation.isEmpty() || positionLocation.isBlank()) {
      throw new InvalidLocationException("Position location cannot be empty or null.");
    }

    if (positionLocation.length() > 50) {
      throw new InvalidLocationException("Position location cannot exceed 50 characters.");
    }
  }

  private void validateKeyWord(String keyWord) {
    if (keyWord == null || keyWord.isEmpty() || keyWord.isBlank()) {
      throw new InvalidKeyWordException("Keyword cannot be null or empty.");
    }

    if (keyWord.length() > 50) {
      throw new InvalidKeyWordException("Keyword cannot exceed 50 characters.");
    }
  }

  private void validateApiKey(String apiKey) {
    if (!clientRepository.existsByApiKey(apiKey)) {
      throw new ApiKeyNotFoundException(apiKey);
    }
  }
}
