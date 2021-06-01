package com.filipszumowski.dnd.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.notentity.Skill;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@JsonIgnoreProperties
public class AbilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String index;
    private String name;
    private String full_name;
    private String desc;
    @OneToMany
    private List<Skill> skills;
    private String url;

}
