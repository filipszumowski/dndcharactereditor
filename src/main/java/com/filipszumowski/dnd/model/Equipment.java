package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.creator.CharacterCreate;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equId;
    private String indexName;
    private String name;
    @Column(name = "equipmentcategory")

    private String weaponcategory;
    private String weaponrange;
    private String damage;
    private Integer weight;
    private String url;

    @ManyToMany(mappedBy = "equipment")
    private List<CharacterCreate> charactercreates;
    public Equipment (){};
}
