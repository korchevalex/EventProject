package com.events.EventsProject.service;

import com.events.EventsProject.model.entity.Club;
import com.events.EventsProject.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> getAll() {
        return clubRepository.findAll();
    }

    public Club getById(long id) {
        if (clubRepository.findById(id).isPresent()) {
            return clubRepository.findById(id).get();
        } else {
            return null;
        }
    }
}
