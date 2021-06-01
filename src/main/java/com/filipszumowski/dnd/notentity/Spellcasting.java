package com.filipszumowski.dnd.notentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filipszumowski.dnd.common.APIReference;
import com.filipszumowski.dnd.common.AbilityScore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@JsonIgnoreProperties
public class Spellcasting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer level;
   /* @ManyToMany
    private List<AbilityScore> spellcasting_ability; //APIReference
*/

}
