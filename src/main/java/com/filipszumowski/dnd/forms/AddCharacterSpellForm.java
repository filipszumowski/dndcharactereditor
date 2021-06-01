package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.model.Race;
import com.filipszumowski.dnd.model.Spells;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class AddCharacterSpellForm {
    @NotNull
    private Integer characterId;
    @NotNull
    private Integer spellId;
    private Iterable<Spells> spellsIterable;
    private CharacterCreate characterCreate;
    public AddCharacterSpellForm(){}

    public AddCharacterSpellForm(Iterable<Spells> spellsIterable, CharacterCreate characterCreate) {
        this.spellsIterable = spellsIterable;
        this.characterCreate = characterCreate;
    }
}
