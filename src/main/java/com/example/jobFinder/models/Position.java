package com.example.jobFinder.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_position")
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String positionName;

  @Column(length = 50)
  private String location;

  @Column(unique = true)
  private String url;

  public Position() {}

  public Position(String positionName, String location) {
    this.positionName = positionName;
    this.location = location;
  }
}
