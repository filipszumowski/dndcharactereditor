package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.model.CharacterCreate;
import com.filipszumowski.dnd.model.Trait;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddCharacterTraitForm {

    @NotNull
    private Integer characterId;
    @NotNull
    private Integer traitId;
    private Iterable<Trait> trait;
    private CharacterCreate characterCreate;
    public AddCharacterTraitForm(){}

    public AddCharacterTraitForm(Iterable<Trait> traitIterable, CharacterCreate characterCreate) {
        this.trait = traitIterable;
        this.characterCreate = characterCreate;
    }
}
