package com.filipszumowski.dnd.notentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.model.Spell;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@JsonIgnoreProperties
public class SpellsForClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer count;
    @ManyToMany
    private List<Spell> results; //APIReference
}
