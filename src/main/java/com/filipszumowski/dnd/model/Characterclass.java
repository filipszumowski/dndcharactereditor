package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.common.Choice;
import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.notentity.Spellcasting;
import com.filipszumowski.dnd.notentity.StartingEquipment;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties

public class Characterclass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;
    private String indexName;
    private String name;
    private Integer hitDie;
    private String url;
    @ManyToMany(mappedBy = "characterClass")
    private List<CharacterCreate> charactercreates;


    public Characterclass (){};



    /*@ManyToMany
    private List <StartingEquipment> starting_equipment; //Object*/
    /*@ManyToMany
    private List <Choice> proficiency_choices;
    */

    /*@ManyToMany
    private List <Spellcasting> spellcasting;*/ //Object




}
