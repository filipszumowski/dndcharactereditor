package com.filipszumowski.dnd.model;

import com.filipszumowski.dnd.model.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    private String name;

    private int strScore;

    private int dexScore;

    private int constScore;

    private int intScore;

    private int wisScore;

    private int charScore;
    /*@ManyToOne
    private Player player;*/
    @ManyToOne
    private Race race;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "character_class", joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    private Set<Characterclass> characterClass;
    @ManyToMany
    private Set<Spell> spells;
    @ManyToMany
    private Set<Proficiency> proficiencies;
    @ManyToMany
    private Set<Equipment> equipment;
    @ManyToMany
    private Set <Trait> traits;
    /*@ManyToMany
    private List <Skill> skills;*/

    public CharacterCreate () {}

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

    public Set<Spell> getSpells() {return spells;}

    public Set<Proficiency> getProficiencies() {return proficiencies;}

    public Set<Equipment> getEquipment() {return equipment;}

    public Set<Trait> getTraits() {return traits;}

    public Integer getCharacterId() {
        return characterId;
    }

    public CharacterCreate(Integer characterId,
                           String name, @Min(10) int strScore,
                           @Min(10) int dexScore, @Min(10) int constScore,
                           @Min(10) int intScore, @Min(10) int wisScore,
                           @Min(10) int charScore, Race race,
                           Set<Characterclass> characterClass,
                           Set<Spell> spells, Set<Proficiency> proficiencies,
                           Set<Equipment> equipment, Set<Trait> traits) {
        this.characterId = characterId;
        this.name = name;
        this.strScore = strScore;
        this.dexScore = dexScore;
        this.constScore = constScore;
        this.intScore = intScore;
        this.wisScore = wisScore;
        this.charScore = charScore;
        this.race = race;
        this.characterClass = characterClass;
        this.spells = spells;
        this.proficiencies = proficiencies;
        this.equipment = equipment;
        this.traits = traits;

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

    public Set<Characterclass> getCharacterClass() {
        return characterClass;
    }


}
