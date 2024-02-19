package com.example.jobFinder.mappers;

import com.example.jobFinder.models.Client;
import com.example.jobFinder.models.dtos.ClientResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {

  public abstract ClientResponseDTO clientToDTO(Client client);

  public abstract List<ClientResponseDTO> clientsToDTOs(List<Client> clients);
}
