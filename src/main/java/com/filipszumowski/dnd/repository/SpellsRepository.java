package com.filipszumowski.dnd.repository;

import com.filipszumowski.dnd.model.Equipment;
import com.filipszumowski.dnd.model.Spells;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SpellsRepository extends JpaRepository<Spells, Integer> {
}

