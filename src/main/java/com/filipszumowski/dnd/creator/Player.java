package com.filipszumowski.dnd.creator;

import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    @OneToMany
    private List<CharacterCreate> characterCreates;

}
