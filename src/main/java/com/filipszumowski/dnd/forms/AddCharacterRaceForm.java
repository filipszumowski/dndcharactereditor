package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.model.Proficiency;
import com.filipszumowski.dnd.model.Race;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class AddCharacterRaceForm {

    @NotNull
    private Integer characterId;
    @NotNull
    private Integer raceId;
    private Iterable<Race> raceIterable;
    private CharacterCreate characterCreate;
    public AddCharacterRaceForm(){}

    public AddCharacterRaceForm(Iterable<Race> raceIterable, CharacterCreate characterCreate) {
        this.raceIterable = raceIterable;
        this.characterCreate = characterCreate;
    }
}
