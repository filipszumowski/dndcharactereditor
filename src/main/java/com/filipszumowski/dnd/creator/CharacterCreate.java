package com.filipszumowski.dnd.creator;

import com.filipszumowski.dnd.model.*;
import com.filipszumowski.dnd.notentity.Skill;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@Entity
@Data
public class CharacterCreate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer characterId;
    private String name;
    @Min(10)
    private int strScore;
    @Min(10)
    private int dexScore;
    @Min(10)
    private int constScore;
    @Min(10)
    private int intScore;
    @Min(10)
    private int wisScore;
    @Min(10)
    private int charScore;
    /*@ManyToOne
    private Player player;*/
    @ManyToMany
    private List<Race> race1;
    @ManyToMany
    private List<Characterclass> characterClass;
    @ManyToMany
    private List<Spells> spells;
    @ManyToMany
    private List<Proficiency> proficiencies;
    @ManyToMany
    private List<Equipment> equipment;
    @ManyToMany
    private List <Trait> traits;
    /*@ManyToMany
    private List <Skill> skills;*/

    public CharacterCreate () {}

    public void addClass(Characterclass characterclass) {characterClass.add(characterclass);}

    public void addRace(Race race) {race1.add(race);}

    public void addSpells(Spells spell) {spells.add(spell);}

    public void addProficiencies(Proficiency proficiency) {proficiencies.add(proficiency);}

    public void addEquipment(Equipment item) {equipment.add(item);}

    public void addTrait(Trait trait) {traits.add(trait);}

    public List<Spells> getSpells() {return spells;}

    public List<Proficiency> getProficiencies() {return proficiencies;}

    public List<Equipment> getEquipment() {return equipment;}

    public List<Trait> getTraits() {return traits;}

    public Integer getCharacterId() {
        return characterId;
    }

    public CharacterCreate(Integer characterId,
                           String name, @Min(10) int strScore,
                           @Min(10) int dexScore, @Min(10) int constScore,
                           @Min(10) int intScore, @Min(10) int wisScore,
                           @Min(10) int charScore, List<Race> race,
                           List<Characterclass> characterClass,
                           List<Spells> spells, List<Proficiency> proficiencies,
                           List<Equipment> equipment, List<Trait> traits) {
        this.characterId = characterId;
        this.name = name;
        this.strScore = strScore;
        this.dexScore = dexScore;
        this.constScore = constScore;
        this.intScore = intScore;
        this.wisScore = wisScore;
        this.charScore = charScore;
        this.race1 = race;
        this.characterClass = characterClass;
        this.spells = spells;
        this.proficiencies = proficiencies;
        this.equipment = equipment;
        this.traits = traits;

    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
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

    public List<Race> getRace() {
        return race1;
    }

    public List<Characterclass> getCharacterClass() {
        return characterClass;
    }


}
