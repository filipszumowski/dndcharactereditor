package com.filipszumowski.dnd.service;

import com.filipszumowski.dnd.model.CharacterCreate;
import com.filipszumowski.dnd.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterCreateService {

    final CharacterCreateRepository characterCreateRepository;

    public CharacterCreateService(CharacterCreateRepository characterCreateRepository) {
        this.characterCreateRepository = characterCreateRepository;
    }

    public List<CharacterCreate> listAllCharacters() {
        return characterCreateRepository.findAll();
    }

    public void saveCharacter(CharacterCreate characterCreate) {
        characterCreateRepository.save(characterCreate);
    }

    public CharacterCreate getCharacter(Integer id) {
        return characterCreateRepository.getById(id);
    }

    public void deleteCharacter(Integer id) {
        characterCreateRepository.deleteById(id);
    }



}