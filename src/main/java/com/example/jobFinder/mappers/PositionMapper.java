package com.example.jobFinder.mappers;

import com.example.jobFinder.models.Position;
import com.example.jobFinder.models.dtos.PositionResponseDTO;
import java.net.URL;
import java.util.List;
import lombok.SneakyThrows;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class PositionMapper {

  @Mapping(target = "url", source = "url", qualifiedByName = "stringToUrl")
  public abstract PositionResponseDTO positionToDTO(Position position);

  public abstract List<PositionResponseDTO> positionsToDTOs(List<Position> positions);

  @SneakyThrows
  @Named("stringToUrl")
  URL mapToUrl(String url) {
    return new URL(url);
  }
}
