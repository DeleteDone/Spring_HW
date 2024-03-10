# Фреймворк Spring (семинары)


## Урок 1. Системы сборки Maven и Gradle для разработки Java приложений


Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости
Задание:
1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
3. Создайте класс Person с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.

## Урок 2. Основы Spring. Spring Boot
Базовое задание:
Добавить в простое CRUD веб-приложение, которое было разработано на семинаре функцию удаления данных о пользователе:
1) В класс UserRepository добавить метод public void deleteById(int id)(подсказка: SQL запрос "DELETE FROM userTable WHERE id=?", метод jdbc.update) - удаления записи пользователя из БД по ID.
2) В класс UserService добавить метод public void deleteById(int id)(подсказка: в нем вызывается метод userRepository.deleteById) - удаление пользователя через репозиторий.
3) В класс UserController добавить метод public String deleteUser(@PathVariable("id") int id)(с аннотацией: @GetMapping("user-delete/{id}")) (подсказка: в нем вызывается метод userService.deleteById) - перехват команды на удаление студента от браузера.

Если задание выполнено верно, то при запуске приложения по адресу http://localhost:8080/users будет работать кнопка удаления пользователя по ID.

Задание "со звездочкой":
Реализовать метод обновления данных о пользователе.
- @GetMapping("/user-update/{id}")
- @PostMapping("/user-update")
- User update(User user)
- User getOne(int id)

## Урок 3. Использование Spring для разработки серверного приложения

Задание: Используя Spring, создайте серверное REST приложение. Добавить функционал в приложение разработанное на семинаре:
=============================== Проверка работы ====================================
Для теcтирования проекта использовать программу PostMan:
a) Добавление пользователя - запрос :
метод - POST
адрес - http://localhost:8080/user/body
тело -
{
"name":"Artur",
"age":23,
"email":"exam1@yandex.ru"
}
b) Получение списка пользователей на сервере - запрос:
метод - GET
адрес - http://localhost:8080/user
c) Проверка сортировки - запрос:
метод - GET
адрес - http://localhost:8080/tasks/sort
d) Проверка фильтрации - запрос:
метод - GET
адрес - http://localhost:8080/tasks/filter/23
e) Проверка среднего арифметического - запрос:
метод - GET
адрес - http://localhost:8080/tasks/calc
==================================_________=======================================

Базовое задание
1) В класс RegistrationService добавить поля UserService, NotificationService(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)
2) Разработать метод processRegistration в котором:
- создается пользователь из параметров метода
- созданный пользователь добавляется в репозиторий
- через notificationService выводится сообщение в консоль
3) В TaskController добавить обработчики filterUsersByAge()(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable

Задание со звездочкой
1) В классе UserController добавить обработчик userAddFromParam извлекающий данные для создания пользователя из параметров HTTP запроса
2) Перенести репозиторий проекта с List<User> на базу данных H2

# Урок 5. Spring Data для работы с базами данных
Базовое задание:
Условие:
Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. Требуется реализовать следующие функции:

Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере: @GetMapping("/status/{status}") public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
Изменение статуса задачи. Подсказка метод в контроллере: @PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
Удаление задачи.
Подсказка метод в контроллере:
@DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id)

Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long>

Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

Подсказка понадобится энумератор:
enum TaskStatus {
NOT_STARTED, IN_PROGRESS, COMPLETED;
}


# Урок 6. Проектирование и реализация API для серверного приложения.
Базовое задание:
Условие:
Важно! В проекте используем обязательно Spring Data и Lombok!
Разработайте небольшое веб-приложение на Spring Boot, которое будет представлять из себя сервис для учета личных заметок. Приложение должно поддерживать следующие функции:
Все методы контроллера возвращают ResponseEntity(как на семинаре)
1. Добавление заметки. (Подсказка @PostMapping )
2. Просмотр всех заметок.(Подсказка @GetMapping )
3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
Структура заметки:
- ID (автоинкрементное)(тип - Long)
- Заголовок (не может быть пустым)(тип - String)
- Содержимое (не может быть пустым)(тип - String)
- Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)

Подсказка:
Репозиторий насладует JpaRepository<Note, Long>. В репозитории добавляем метод Optional<Note> findById(Long id);
Подсказка:
В проект добавляем зависимости: spring data jpa, h2, lombok, spring web



# Урок 7. Spring Security. Работа с JWT. Защита от основных видов атак.
Базовое задание:
Внимание ДЗ выполнять в версии SpringBoot:2.7.14(модули security и web)
Вам необходимо создать Spring Boot приложение, которое управляет доступом к ресурсам в зависимости от роли пользователя. У вас должно быть два типа пользователей: USER и ADMIN.
1. Создайте ресурс /private-data, доступный только для аутентифицированных пользователей с ролью ADMIN.
2. Создайте ресурс /public-data, доступный для всех аутентифицированных пользователей независимо от их роли.
3. Реализуйте форму входа для аутентификации пользователей с использованием стандартных средств Spring Security.
4. Если неаутентифицированный пользователь пытается получить доступ к /private-data, он должен быть перенаправлен на форму входа.
_
Подсказка:
Файл HTML:
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="/login" method="post">
<div>
<label for="username">Username:</label>
<input type="text" id="username" name="username"/>
</div>
<div>
<label for="password">Password:</label>
<input type="password" id="password" name="password"/>
</div>
<input type="submit" value="Login"/>
</form>
</body>
</html>
Подсказка:
1) http.authorizeRequests()
.antMatchers("/private-data").hasRole("ADMIN")
.antMatchers("/public-data").authenticated()
.and()
.formLogin()
.and()
.logout()
.logoutSuccessUrl("/login");
2) auth.inMemoryAuthentication()
.withUser("user").password("{noop}password").roles("USER")
.and()
.withUser("admin").password("{noop}password").roles("ADMIN");
