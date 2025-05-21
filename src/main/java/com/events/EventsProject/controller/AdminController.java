package com.events.EventsProject.controller;

import com.events.EventsProject.service.ReviewService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private final ReviewService reviewService;

    public AdminController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("admin/reviews")
    public String viewReviews(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        return "view-reviews";
    }
}
