package com.filipszumowski.dnd.repository;


import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.model.Spells;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

@Repository
@Transactional
public interface CharacterclassRepository extends JpaRepository<Characterclass, Integer> {

}
