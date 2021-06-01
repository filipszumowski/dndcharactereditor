package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.model.Race;
import com.filipszumowski.dnd.model.Trait;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AddCharacterTraitForm {

    @NotNull
    private Integer characterId;
    @NotNull
    private Integer traitId;
    private Iterable<Trait> traitIterable;
    private CharacterCreate characterCreate;
    public AddCharacterTraitForm(){}

    public AddCharacterTraitForm(Iterable<Trait> traitIterable, CharacterCreate characterCreate) {
        this.traitIterable = traitIterable;
        this.characterCreate = characterCreate;
    }
}
