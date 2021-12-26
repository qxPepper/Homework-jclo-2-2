package ru.netology.homeworkjclo22.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
public class User {
    @NotNull
    @NotBlank
    private String user;

    @NotNull
    @NotBlank
    private String password;
}
