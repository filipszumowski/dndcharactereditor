package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.creator.CharacterCreate;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties
public class Proficiency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profId;
    private String indexName;
    private String type;
    private String name;
   @ManyToMany
    private List <Characterclass> aClasses;
    @ManyToMany
    private List <Race> races;
    private String url;
    @ManyToMany(mappedBy = "proficiencies")
    private List<CharacterCreate> charactercreates;

    public Proficiency (){};
   /* @ManyToMany
    private List <EquipmentCat> references;
*/


}
