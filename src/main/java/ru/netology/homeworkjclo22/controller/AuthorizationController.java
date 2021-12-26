package ru.netology.homeworkjclo22.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import ru.netology.homeworkjclo22.exceptions.UnauthorizedUser;
import ru.netology.homeworkjclo22.repository.Authorities;
import ru.netology.homeworkjclo22.service.AuthorizationService;
import ru.netology.homeworkjclo22.user.User;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User userObject) {
        return service.getAuthorities(userObject);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public String handleInvalidCredentials(BindException e) {
        return "User name or password is empty.";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
