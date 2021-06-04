package com.filipszumowski.dnd.repository;

import com.filipszumowski.dnd.model.CharacterCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CharacterCreateRepository extends JpaRepository<CharacterCreate, Integer> {
}

