package com.filipszumowski.dnd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equId;
    private String indexName;
    @Size(min = 4, max = 60)
    private String name;
    @Size(max = 255)
    @Nullable
    private String description;
    @Size(min = 4, max = 60)
    private String weaponcategory;
    @Min(1)
    @Max(60)
    private Integer weaponrange;
    @Positive
    @Range(min = 1l, max=1000)
    private Long damage;
    @Positive
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
