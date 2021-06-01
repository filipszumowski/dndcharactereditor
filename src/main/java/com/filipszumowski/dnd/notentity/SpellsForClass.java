package com.filipszumowski.dnd.notentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.common.APIReference;
import com.filipszumowski.dnd.model.Spells;
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
    private List<Spells> results; //APIReference
}
