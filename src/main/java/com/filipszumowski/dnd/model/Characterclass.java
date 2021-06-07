package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties

public class Characterclass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;
    private String indexName;
    @Size(min = 4, max = 30)
    private String name;
    @Min(6)
    @Max(12)
    private Integer hitDie;
    @URL
    private String url;
    @ManyToMany(mappedBy = "characterClass")
    private List<CharacterCreate> charactercreates;


    @Override
    public String toString() {
        return this.name;
    }

    public Characterclass (){};

    public Characterclass(Integer classId, String indexName, String name, Integer hitDie, String url, List<CharacterCreate> charactercreates
    ) {
        this.classId = classId;
        this.indexName = indexName;
        this.name = name;
        this.hitDie = hitDie;
        this.url = url;
        this.charactercreates = charactercreates;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHitDie() {
        return hitDie;
    }

    public void setHitDie(Integer hitDie) {
        this.hitDie = hitDie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

   /* public CharacterCreate getCharactercreates() {
        return charactercreates;
    }

    public void setCharactercreates(CharacterCreate charactercreates) {
        this.charactercreates = charactercreates;
    }*/

    /*@ManyToMany
    private List <StartingEquipment> starting_equipment; //Object*/
    /*@ManyToMany
    private List <Choice> proficiency_choices;
    */

    /*@ManyToMany
    private List <Spellcasting> spellcasting;*/ //Object




}
