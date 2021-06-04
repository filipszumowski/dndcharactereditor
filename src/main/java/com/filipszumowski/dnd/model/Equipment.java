package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equId;
    private String indexName;
    private String name;
    private String weaponcategory;
    private String weaponrange;
    private String damage;
    private Integer weight;
    private String url;
    @Nullable
    @ManyToMany(mappedBy = "equipment")
    private List<CharacterCreate> charactercreates;
    public Equipment (){};

    @Override
    public String toString() {
        return this.name;
    }
}
