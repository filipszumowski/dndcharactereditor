package com.filipszumowski.dnd.notentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.model.Equipment;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@JsonIgnoreProperties
public class StartingEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String indexName;
    @ManyToMany
    private List<Characterclass> aClasses;
    @ManyToMany
    private List<Equipment> equipment;
   /* @ManyToMany
    private List<Equipment> starting_equipment_options; //Choice*/
    private String url;

}
