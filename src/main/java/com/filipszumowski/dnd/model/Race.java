package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.common.AbilityBonus;
import com.filipszumowski.dnd.creator.CharacterCreate;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceId;
    private String indexName;
    private String name;
    private Integer speed;
    @ManyToMany(mappedBy = "race1")
    private List<CharacterCreate> charactercreates;
    /*@ManyToMany
    private List <AbilityBonus> ability_bonuses;
   */
    @ManyToMany
    private List <Proficiency> starting_proficiencies;
    @ManyToMany
    private List<Trait> traits;
    private String url;

    public Race (){};
}
