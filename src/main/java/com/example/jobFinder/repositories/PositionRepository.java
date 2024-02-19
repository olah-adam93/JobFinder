package com.example.jobFinder.repositories;

import com.example.jobFinder.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

  @Query(
      "SELECT p FROM Position p WHERE p.location = :location AND p.positionName LIKE CONCAT('%', :keyWord, '%')")
  List<Position> findAllByLocationAndKeyWord(String location, String keyWord);
}
