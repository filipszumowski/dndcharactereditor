package com.filipszumowski.dnd.service;

import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.repository.CharacterclassRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CharClassService {

    final CharacterclassRepository characterclassRepository;

    public CharClassService(CharacterclassRepository characterclassRepository) {
        this.characterclassRepository = characterclassRepository;
    }

    public List<Characterclass> listAllClasses() { return characterclassRepository.findAll();
    }

    public void saveClass(Characterclass characterclass) {
        characterclassRepository.save(characterclass);
    }

    public Characterclass getClass(Integer id) {
        return characterclassRepository.getById(id);
    }

    public Set<String> getClassName(Integer id) {
        Set<String> names = new HashSet<>();
        names.add(characterclassRepository.getById(id).getName());
        return names;
    }

    public void deleteClass(Integer id) {
        characterclassRepository.deleteById(id);
    }
}