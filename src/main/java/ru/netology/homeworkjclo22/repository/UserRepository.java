package ru.netology.homeworkjclo22.repository;

import ru.netology.homeworkjclo22.user.User;
import ru.netology.homeworkjclo22.user.UserValid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    Map<User, List<Authorities>> testUsers = new HashMap<>();
    String user;
    String password;

    public Map<User, List<Authorities>> testInit() {
        List<Authorities> testAuthorities = new ArrayList<>();
        testAuthorities.add(Authorities.READ);
        testAuthorities.add(Authorities.WRITE);
        testUsers.put(new User("Vasya", "1234"), testAuthorities);

        testAuthorities = new ArrayList<>();
        testAuthorities.add(Authorities.READ);
        testAuthorities.add(Authorities.WRITE);
        testAuthorities.add(Authorities.DELETE);
        testUsers.put(new User("Katya", "7777"), testAuthorities);

        return testUsers;
    }

    @UserValid
    public List<Authorities> getUserAuthorities(User userObject) {
        testUsers = testInit();
        HandlerMethodArgumentResolver(userObject);

        for (User element : testUsers.keySet()) {
            if ((element.getUser().equals(user)) && (element.getPassword().equals(password))) {
                return testUsers.get(element);
            }
        }
        return new ArrayList<>();
    }

    public void HandlerMethodArgumentResolver(User userObject) {
        user = userObject.getUser();
        password = userObject.getPassword();
    }
}

