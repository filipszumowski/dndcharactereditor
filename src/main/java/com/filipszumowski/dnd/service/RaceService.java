package com.filipszumowski.dnd.service;

import com.filipszumowski.dnd.model.Equipment;
import com.filipszumowski.dnd.model.Race;
import com.filipszumowski.dnd.repository.EquipmentRepository;
import com.filipszumowski.dnd.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RaceService {

    final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> listAllRaces() {
        return raceRepository.findAll();
    }

    public void saveRace(Race race) {
        raceRepository.save(race);
    }

    public Race getRace(Integer id) {
        return raceRepository.getById(id);
    }

    public void deleteRace(Integer id) {
        raceRepository.deleteById(id);
    }
}
