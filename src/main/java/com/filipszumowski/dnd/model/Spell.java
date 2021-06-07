package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Timespan;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spellId;
    @Size(min = 4, max = 60)
    private String name;
    private String indexName;
    @Size(max = 255)
    @Nullable
    private String description;
    //private Integer higher_level; //List
    @Min(1)
    @Max(60)
    private String spellRange;
    private String duration;
    private String concentration;
    @Min(1)
    @Max(60)
    private String casting_time;
    @Min(1)
    @Max(20)
    private Integer level;
    @Size(min = 1, max = 60)
    private String attackType;
    @Size(min = 1, max = 60)
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
