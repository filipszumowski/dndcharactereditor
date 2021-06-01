package com.filipszumowski.dnd.repository;

import com.filipszumowski.dnd.model.Equipment;
import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
}
