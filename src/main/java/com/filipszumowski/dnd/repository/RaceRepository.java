package com.filipszumowski.dnd.repository;

import com.filipszumowski.dnd.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RaceRepository extends JpaRepository<Race, Integer> {
}
