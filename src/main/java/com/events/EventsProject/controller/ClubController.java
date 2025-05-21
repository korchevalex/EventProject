package com.events.EventsProject.controller;

import com.events.EventsProject.model.entity.Club;
import com.events.EventsProject.service.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String viewClubs(Model model) {
        model.addAttribute("clubs", clubService.getAll());
        return "clubs";
    }

    @GetMapping("/clubs/{id}")
    public String viewClub(Model model, @PathVariable long id) {
        Club club = clubService.getById(id);
        model.addAttribute("themes", club.getThemes().split("; "));
        model.addAttribute("club", club);
        return "club";
    }
}
