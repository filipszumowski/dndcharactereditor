package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties
public class Trait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer traitId;
    private String indexName;
    /*@ManyToMany
    private List<Race> races;*/
    private String name;
    private String description;
    /*@ManyToMany
    private List<Proficiency> proficiencies;*/
    /*@ManyToMany
    private List<Proficiency> proficiency_choices; //choice*/
    private String url;
    @ManyToMany(mappedBy = "traits")
    private List<CharacterCreate> charactercreates;
    public Trait (){};

    @Override
    public String toString() {
        return this.name;
    }
}
