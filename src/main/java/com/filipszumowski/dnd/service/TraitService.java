package com.filipszumowski.dnd.service;

import com.filipszumowski.dnd.model.Trait;
import com.filipszumowski.dnd.repository.TraitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraitService {
    final TraitRepository traitRepository;

    public TraitService(TraitRepository traitRepository) {
        this.traitRepository = traitRepository;
    }

    public List<Trait> listAllTraits() {
        return traitRepository.findAll();
    }

    public void saveTrait(Trait trait) {
        traitRepository.save(trait);
    }

    public Trait getTrait(Integer id) {
        return traitRepository.getById(id);
    }

    public void deleteTrait(Integer id) {
        traitRepository.deleteById(id);
    }
}
