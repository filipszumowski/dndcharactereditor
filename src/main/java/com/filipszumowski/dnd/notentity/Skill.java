package com.filipszumowski.dnd.notentity;

import com.filipszumowski.dnd.model.CharacterCreate;

import java.util.List;

/*@Entity
@Data
@JsonIgnoreProperties*/
public class Skill {

   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillId;
    private String indexName;
    private String name;
    private String description; //list
   // @ManyToMany(mappedBy = "skill")
    private List<CharacterCreate> charactercreates;
    /*@ManyToMany
    private List<AbilityScore> ability_score; //APIReference
    */private String url;

}
