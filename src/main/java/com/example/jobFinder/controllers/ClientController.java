package com.example.jobFinder.controllers;

import com.example.jobFinder.models.dtos.ClientResponseDTO;
import com.example.jobFinder.models.dtos.CreateClientDTO;
import com.example.jobFinder.services.client.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

  private final ClientService clientService;

  @Autowired
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @Operation(summary = "Create new client")
  @PostMapping("")
  public ResponseEntity<ClientResponseDTO> createNewClient(
      @Valid @RequestBody CreateClientDTO newClient) {
    return ResponseEntity.status(201).body(clientService.addNewClient(newClient));
  }
}
