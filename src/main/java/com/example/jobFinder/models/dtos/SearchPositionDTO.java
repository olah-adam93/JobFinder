package com.example.jobFinder.models.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPositionDTO {

  private String keyWord;
  private String location;
}
