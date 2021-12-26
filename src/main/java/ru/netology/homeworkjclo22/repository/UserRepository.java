package ru.netology.homeworkjclo22.repository;

import ru.netology.homeworkjclo22.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    public Map<User, List<Authorities>> testInit() {
        Map<User, List<Authorities>> testUsers = new HashMap<>();

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

    public List<Authorities> getUserAuthorities(String user, String password) {
        Map<User, List<Authorities>> testUsers = testInit();

        for (User element : testUsers.keySet()) {
            if ((element.getUser().equals(user)) && (element.getPassword().equals(password))) {
                return testUsers.get(element);
            }
        }
        return new ArrayList<>();
    }
}
