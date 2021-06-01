package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.model.Equipment;
import com.filipszumowski.dnd.model.Proficiency;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class AddCharacterProfForm {

    @NotNull
    private Integer characterId;
    @NotNull
    private Integer profId;
    private Iterable<Proficiency> proficiency;
    private CharacterCreate characterCreate;
    public AddCharacterProfForm(){}

    public AddCharacterProfForm(Iterable<Proficiency> proficiencyIterable, CharacterCreate characterCreate) {
        this.proficiency = proficiencyIterable;
        this.characterCreate = characterCreate;
    }
}
