package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.model.Characterclass;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddCharacterClassForm {

    @NotNull
    private Integer characterId;
    @NotNull
    private Integer classId;
    private Iterable<Characterclass> characterclassIterable;

    private CharacterCreate characterCreate;
    public AddCharacterClassForm() {
    }

    public AddCharacterClassForm(Iterable<Characterclass> characterclassIterable,
                                 CharacterCreate characterCreate) {
        this.characterclassIterable = characterclassIterable;
        this.characterCreate = characterCreate;
    }
}