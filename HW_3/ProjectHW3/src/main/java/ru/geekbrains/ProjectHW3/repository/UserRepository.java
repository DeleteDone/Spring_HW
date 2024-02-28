package ru.geekbrains.ProjectHW3.repository;

import ru.geekbrains.ProjectHW3.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }



    private List<User> users = new ArrayList<>();

}