package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer raceId;
    private String indexName;
    @Size(min = 1, max = 60)
    private String name;
    @Min(1)
    @Max(60)
    private Integer speed;
    @OneToMany
    private List<CharacterCreate> charactercreates;
    /*@ManyToMany
    private List <AbilityBonus> ability_bonuses;
   */
    /*@ManyToMany
    private List <Proficiency> starting_proficiencies;
    @ManyToMany
    private List<Trait> traits;
    */private String url;

    public Race (){};

    public Race(Integer raceId, String indexName, String name, Integer speed, List<CharacterCreate> charactercreates, String url) {
        this.raceId = raceId;
        this.indexName = indexName;
        this.name = name;
        this.speed = speed;
        this.charactercreates = charactercreates;
        this.url = url;
    }


}
