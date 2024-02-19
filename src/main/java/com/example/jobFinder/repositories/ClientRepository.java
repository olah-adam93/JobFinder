package com.example.jobFinder.repositories;

import com.example.jobFinder.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  boolean existsByApiKey(String apiKey);

  boolean existsByEmail(String email);
}
