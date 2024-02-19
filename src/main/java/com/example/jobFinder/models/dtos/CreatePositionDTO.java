package com.example.jobFinder.models.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePositionDTO {

  private String positionName;
  private String location;
}
