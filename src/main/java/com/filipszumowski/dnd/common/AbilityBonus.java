package com.filipszumowski.dnd.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data
@JsonIgnoreProperties
public class AbilityBonus {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private Integer bonus;
   @ManyToMany
   private List<AbilityScore> ability_score;
}
