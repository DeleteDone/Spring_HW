package ru.geekbrains.ProjectHW4Spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.ProjectHW4Spring.Domain.Input;


/**
 * Контроллер обработки задач.
 */
@Controller
public class MyController {

    /**
     * Главная страница по адресу: http://localhost:8080
     * @param model
     * @return Возвращает домашнюю страницу
     */
    @GetMapping("/")
    public String home(Model model) {
        String message1 = "Урок 4. Spring MVC. Использование шаблонизатора Thymeleaf";
        String message2 = "Для проверки задания №2 перейдите по адресу: http://localhost:8080/task2";
        String message3 = "Для проверки задания №3 перейдите по адресу: http://localhost:8080/task3";
        model.addAttribute("message1", message1);
        model.addAttribute("message2", message2);
        model.addAttribute("message3", message3);
        return "home";
    }


    /**
     * Получение страницы по адресу: http://localhost:8080/task2 с задачей №2
     * @param model
     * @return Возвращает страницу с выполненной задачей.
     */
    @GetMapping("/task2")
    public String task2(Model model) {
        model.addAttribute("name", "Nikita");
        model.addAttribute("lastName", "Lyskov");
        return "task2Page";
    }


    /**
     * Получение страницы по адресу: http://localhost:8080/task3 с пустой формой для заполнения
     * @param model
     * @return
     */
    @GetMapping("/task3")
    public String form(Model model) {
        model.addAttribute("input", new Input());
        return "task3";
    }


    /**
     * Отправка данных из формы по адресу: http://localhost:8080/task3 и их вывод на странице
     * @param input подставляется параметр из формы ввода в виде объекта класса Input
     * @param model для работы Thymeleaf
     * @return  Возвращает страницу с результатом ввода пользователя
     */
    @PostMapping("/task3")
    public String formSubmit(@RequestParam String input, Model model) {
        model.addAttribute("input", input);
        return "result";
    }
}

