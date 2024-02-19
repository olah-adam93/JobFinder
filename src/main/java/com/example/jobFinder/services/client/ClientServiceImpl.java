package com.example.jobFinder.services.client;

import com.example.jobFinder.exceptions.InvalidEmailException;
import com.example.jobFinder.exceptions.InvalidNameException;
import com.example.jobFinder.models.Client;
import com.example.jobFinder.models.dtos.ClientResponseDTO;
import com.example.jobFinder.models.dtos.CreateClientDTO;
import com.example.jobFinder.repositories.ClientRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  @Autowired
  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public ClientResponseDTO addNewClient(CreateClientDTO createClientDTO) {

    String name = createClientDTO.getClientName();
    String email = createClientDTO.getClientEmail();

    validateName(name);
    validateEmail(email);

    if (clientRepository.existsByEmail(email)) {
      throw new InvalidEmailException("Email already belongs to an existing user!");
    }

    String apiKey = String.valueOf(generateApiKey());

    Client newClient = new Client(name, email, apiKey);
    clientRepository.save(newClient);

    return new ClientResponseDTO(newClient.getApiKey());
  }

  private void validateName(String name) {
    if (name == null || name.isEmpty() || name.isBlank()) {
      throw new InvalidNameException("Name cannot be empty or blank.");
    }

    if (name.length() > 100) {
      throw new InvalidNameException("Name cannot be longer than 100 characters.");
    }
  }

  private void validateEmail(String email) {
    if (email == null || email.isEmpty() || email.isBlank()) {
      throw new InvalidEmailException("Email cannot be empty or blank.");
    }

    if (!email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
      throw new InvalidEmailException("Given email has wrong format.(example@example.com)");
    }

    if (email.length() > 100) {
      throw new InvalidEmailException("Email cannot be longer than 100 characters.");
    }
  }

  private UUID generateApiKey() {
    UUID key;
    do {
      key = UUID.randomUUID();
    } while (clientRepository.existsByApiKey(String.valueOf(key)));
    return key;
  }
}
