package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties
public class Proficiency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profId;
    private String indexName;
    @Size(min = 4, max = 60)
    private String type;
    @Size(min = 4, max = 60)
    private String name;
    @Size(max = 255)
    @Nullable
    private String description;
   /*@ManyToMany
    private List <Characterclass> aClasses;
    @ManyToMany
    private List <Race> races;
    private String url;*/

    @ManyToMany(mappedBy = "proficiencies")
    private List<CharacterCreate> charactercreates;

    public Proficiency (){};
   /* @ManyToMany
    private List <EquipmentCat> references;
*/

    @Override
    public String toString() {
        return this.name;
    }
}
