package com.example.jobFinder.models.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientDTO {

  private String clientName;
  private String clientEmail;
}
