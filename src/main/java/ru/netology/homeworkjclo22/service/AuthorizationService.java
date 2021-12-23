package ru.netology.homeworkjclo22.service;

import org.springframework.validation.annotation.Validated;
import ru.netology.homeworkjclo22.repository.Authorities;
import ru.netology.homeworkjclo22.user.User;
import ru.netology.homeworkjclo22.repository.UserRepository;

import java.util.List;

@Validated
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User userObject) {
        return userRepository.getUserAuthorities(userObject);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
