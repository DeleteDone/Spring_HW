package ru.geekbrains.ProjectHW3.controllers;


import ru.geekbrains.ProjectHW3.domain.User;
import ru.geekbrains.ProjectHW3.services.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());

        return "User added from body!";
    }
}