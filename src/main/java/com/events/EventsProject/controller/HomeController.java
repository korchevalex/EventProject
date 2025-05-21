package com.events.EventsProject.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.PagesResponse;
import com.events.EventsProject.cms.model.Event;
import com.events.EventsProject.cms.model.EventComparator;
import com.events.EventsProject.model.dto.ReviewDTO;
import com.events.EventsProject.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private IButterCMSClient butterCMSClient;
    private ReviewService reviewService;

    public HomeController(IButterCMSClient butterCMSClient, ReviewService reviewService) {
        this.butterCMSClient = butterCMSClient;
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public String viewIndex(Model model) {
        PagesResponse<Event> events = butterCMSClient.getPages("event", null, Event.class);
        events.getData().sort(new EventComparator());
        events.setData(events.getData().subList(0, 6));
        model.addAttribute("events", events.getData());
        return "index";
    }

    @GetMapping("/reviews")
    public String viewReviews(Model model) {
        model.addAttribute("reviewDTO", new ReviewDTO());
        return "reviews";
    }

    @PostMapping("/reviews")
    public String postReview(@Valid @ModelAttribute ReviewDTO reviewDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reviews";
        }
        reviewService.save(reviewDTO);
        return "redirect:/reviews";
    }

    @GetMapping("/contacts")
    public String viewContact() {
        return "contacts";
    }

    @GetMapping("/gallery")
    public String viewGallery() {
        return "gallery";
    }
}
