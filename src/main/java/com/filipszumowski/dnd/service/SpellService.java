package com.filipszumowski.dnd.service;

import com.filipszumowski.dnd.model.Spell;
import com.filipszumowski.dnd.repository.SpellsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellService {
    final SpellsRepository spellsRepository;

    public SpellService(SpellsRepository spellsRepository) {
        this.spellsRepository = spellsRepository;
    }

    public List<Spell> listAllSpells() {
        return spellsRepository.findAll();
    }

    public void saveSpell(Spell spell) {
        spellsRepository.save(spell);
    }

    public Spell getSpell(Integer id) {
        return spellsRepository.getById(id);
    }

    public void deleteSpell(Integer id) {
        spellsRepository.deleteById(id);
    }
}
