package ru.netology.homeworkjclo22.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.homeworkjclo22.exceptions.InvalidCredentials;
import ru.netology.homeworkjclo22.exceptions.UnauthorizedUser;
import ru.netology.homeworkjclo22.repository.Authorities;
import ru.netology.homeworkjclo22.service.AuthorizationService;
import ru.netology.homeworkjclo22.user.User;
import ru.netology.homeworkjclo22.user.UserValid;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @UserValid User user) {
        return service.getAuthorities(user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String handleInvalidCredentials(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
