package com.filipszumowski.dnd.forms;

import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.model.Equipment;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AddCharacterEquipForm {

    @NotNull
    private Integer characterId;
    @NotNull
    private Integer equId;
    private Iterable<Equipment> equipmentIterable;
private CharacterCreate characterCreate;
    public AddCharacterEquipForm(){}

    public AddCharacterEquipForm(Iterable<Equipment> equipmentIterable, CharacterCreate characterCreate) {
        this.equipmentIterable = equipmentIterable;
        this.characterCreate = characterCreate;
    }
}
