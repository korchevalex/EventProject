package com.events.EventsProject.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDTO {
    @NotBlank(message = "Задължително поле")
    private String author;

    @NotBlank(message = "Задължително поле")
    private String text;
}
