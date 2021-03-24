package pl.kj.mvcproject;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    public UserRepository() {
        userList.add(new User("Jan", "Kowalski", 23));
        userList.add(new User("Andrzej", "Kabacki", 25));
        userList.add(new User("Aneta", "Nowak", 24));
    }

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }
}
