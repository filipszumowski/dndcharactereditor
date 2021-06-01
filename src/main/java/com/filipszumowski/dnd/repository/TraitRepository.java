package com.filipszumowski.dnd.repository;

import com.filipszumowski.dnd.model.Trait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TraitRepository extends JpaRepository<Trait, Integer> {
}
