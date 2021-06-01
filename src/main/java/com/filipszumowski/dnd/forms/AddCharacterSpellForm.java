package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.model.Spell;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class AddCharacterSpellForm {
    @NotNull
    private Integer characterId;
    @NotNull
    private Integer spellId;
    private Iterable<Spell> spells;
    private CharacterCreate characterCreate;
    public AddCharacterSpellForm(){}

    public AddCharacterSpellForm(Iterable<Spell> spells, CharacterCreate characterCreate) {
        this.spells = spells;
        this.characterCreate = characterCreate;
    }
}
