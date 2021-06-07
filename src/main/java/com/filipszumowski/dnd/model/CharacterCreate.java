package com.filipszumowski.dnd.model;

import com.filipszumowski.dnd.model.*;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
public class CharacterCreate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer characterId;
    @Size(min = 1, max = 60)
    private String name;
    @Min(10)
    @Max(40)
    private int strScore;
    @Min(10)
    @Max(40)
    private int dexScore;
    @Min(10)
    @Max(40)
    private int constScore;
    @Min(10)
    @Max(40)
    private int intScore;
    @Min(10)
    @Max(40)
    private int wisScore;
    @Min(10)
    @Max(40)
    private int charScore;
    /*@ManyToOne
    private Player player;*/
    @Nullable
    @ManyToOne//(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.ALL})
    private Race race;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    /*@JoinTable(name = "character_class", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    */
    private List<Characterclass> characterClass;
    @ManyToMany
    private List<Spell> spells;
    @ManyToMany
    private List<Proficiency> proficiencies;
    @ManyToMany(cascade = CascadeType.PERSIST)//, fetch = FetchType.EAGER)
    /*@JoinTable(name = "equipment", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "equ_id"))
    */
    private List<Equipment> equipment;
    @ManyToMany
    private List<Trait> traits;
    /*@ManyToMany
    private List <Skill> skills;*/

    public CharacterCreate() {
    }

//    public void addClass(Characterclass characterclass) {characterClass.add(characterclass);}
//
//    //public void addRace(Race race) {race1.add(race);}
//
//    public void addSpells(Spell spell) {spells.add(spell);}
//
//    public void addProficiencies(Proficiency proficiency) {proficiencies.add(proficiency);}
//
//    public void ment(Equipment item) {equipment.add(item);}
//
//    public void addTrait(Trait trait) {traits.add(trait);}


    public Integer getCharacterId() {
        return characterId;
    }


    public String getName() {
        return name;
    }

    public int getStrScore() {
        return strScore;
    }

    public int getDexScore() {
        return dexScore;
    }

    public int getConstScore() {
        return constScore;
    }

    public int getIntScore() {
        return intScore;
    }

    public int getWisScore() {
        return wisScore;
    }

    public int getCharScore() {
        return charScore;
    }

    public Race getRace() {
        return race;
    }


}
