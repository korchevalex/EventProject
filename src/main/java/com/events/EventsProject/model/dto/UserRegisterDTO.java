package com.events.EventsProject.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterDTO {
    @NotBlank(message = "Потребителско име е задължително поле")
    @Size(min = 4, max = 20, message = "Потребителско име трябва да е между 4 и 20 знака")
    private String username;

    @NotBlank(message = "Име е задължително поле")
    private String firstName;

    @NotBlank(message = "Фамилия е задължително поле")
    private String lastName;

    @NotBlank(message = "Парола е задължително поле")
    @Size(min = 8, message = "Парола трябва да е между 8 и 20 знак")
    private String password;

    @NotBlank(message = "Потвърди парола е задължително поле")
    private String confirmPassword;

    @NotBlank(message = "Имейл е задължително")
    @Email(message = "Имейл трябва да е валиден")
    private String email;
}
