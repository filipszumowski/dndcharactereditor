package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spellId;
    private String name;
    private String indexName;
    private String description;
    //private Integer higher_level; //List
    private String spellRange;
    private String duration;
    private String concentration;
    private String casting_time;
    private Integer level;
    private String attackType;
    private String damage;
    //private APIReference<>school	The magic school this spell belongs to.	APIReference (Magic Schools)
    /*@ManyToMany
    private List<Characterclass> aClasses; //APIReference
    *///subclasses	A list of subclasses that have access to this spell.	listAPIReference (Classes)
    private String url;
    @ManyToMany(mappedBy = "spells")
    private List<CharacterCreate> charactercreates;
    public Spell(){};

    @Override
    public String toString() {
        return this.name;
    }
}
