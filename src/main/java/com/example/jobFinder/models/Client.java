package com.example.jobFinder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100)
  private String clientName;

  @Email
  @Column(length = 100, unique = true)
  private String email;

  @Column(unique = true)
  private String apiKey;

  public Client() {}

  public Client(String clientName, String email, String apiKey) {
    this.clientName = clientName;
    this.email = email;
    this.apiKey = apiKey;
  }
}
