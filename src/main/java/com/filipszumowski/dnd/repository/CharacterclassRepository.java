package com.filipszumowski.dnd.repository;


import com.filipszumowski.dnd.model.Characterclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional

public interface CharacterclassRepository extends JpaRepository<Characterclass, Integer> {



    }

    /*@PersistenceContext
    private EntityManager entityManager;

    public default List<Characterclass> findClassNames(){
        Query query = entityManager.createQuery("SELECT name FROM CharacterCreate b JOIN b.publisher");
        return query.getResultList();*/

    /*SELECT name
    FROM CharacterClass
    INNER JOIN CharacterClreate
        ON characterclass.class_id = Charactercreate.character_id;*/