package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.model.CharacterCreate;
import com.filipszumowski.dnd.model.Race;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class AddCharacterRaceForm {

    @NotNull
    private Integer characterId;
    @NotNull
    private Integer raceId;
    private Iterable<Race> race;
    private CharacterCreate characterCreate;
    public AddCharacterRaceForm(){}

    public AddCharacterRaceForm(Iterable<Race> raceIterable, CharacterCreate characterCreate) {
        this.race = raceIterable;
        this.characterCreate = characterCreate;
    }
}
