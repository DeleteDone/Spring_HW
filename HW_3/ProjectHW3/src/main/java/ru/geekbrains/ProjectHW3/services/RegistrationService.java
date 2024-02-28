package ru.geekbrains.ProjectHW3.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.ProjectHW3.domain.User;
import ru.geekbrains.ProjectHW3.repository.UserRepository;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //Базовое задание
    //1) В класс RegistrationService добавить
    // поля UserService, NotificationService(добавить в IOC контейнер аннотацией
    // @Autowired или через конструктор класса)

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    // Добавляем связь с репозиторием
    @Autowired
    private UserRepository userRepository;


    //2) Разработать метод processRegistration в котором:
    //- создается пользователь из параметров метода
    //- созданный пользователь добавляется в репозиторий
    //- через notificationService выводится сообщение в консоль

    public void processRegistration(String name, int age, String email){
        // Создаем нового пользователя по параметрам метода
        User newUser = userService.createUser(name, age,email);

        // Добавляем пользователя в наш репозиторий пользователей
        dataProcessingService.addUserToList(newUser);

        // Выводим сообщение в консоль
        // (т.к. метод userService.createUser уже вывел сообщение:"A new user has been created: " + user.getName()
        // напишем ещё одно
        notificationService.sendNotification("Новый пользователь успешно создан!");

    }



}
