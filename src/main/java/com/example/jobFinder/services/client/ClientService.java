package com.example.jobFinder.services.client;

import com.example.jobFinder.models.dtos.ClientResponseDTO;
import com.example.jobFinder.models.dtos.CreateClientDTO;

public interface ClientService {

  ClientResponseDTO addNewClient(CreateClientDTO createClientDTO);
}
