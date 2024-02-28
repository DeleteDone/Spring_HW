package ru.geekbrains.ProjectHW3.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.ProjectHW3.domain.User;
import ru.geekbrains.ProjectHW3.services.DataProcessingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }


    //3) В TaskController добавить обработчики filterUsersByAge() (Подсказка @GetMapping("/filter/{age}")) и
    // calculateAverageAge (Подсказка @GetMapping("/calc"))

    // Добавляем необходимые обработчики

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age){
        return service.filterUsersByAge(service.getRepository().getUsers(),age); //4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable
    }

    //метод calculateAverageAge
    //Подсказка  @GetMapping("/calc")
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }

}