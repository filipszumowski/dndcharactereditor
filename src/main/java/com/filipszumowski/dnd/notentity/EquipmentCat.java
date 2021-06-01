package com.filipszumowski.dnd.notentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.model.Equipment;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@JsonIgnoreProperties
public class EquipmentCat {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String index;
    private String name;
   // @OneToMany
    private List<Equipment> equipment;


}
