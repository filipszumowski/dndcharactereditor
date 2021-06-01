package com.filipszumowski.dnd.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.model.Race;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@JsonIgnoreProperties
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String index;
    private String type;
    private String name;
    @ManyToMany
    private List <Characterclass> aClasses;
    @ManyToMany
    private List <Race> races;
    private String url;



}
