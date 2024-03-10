package ru.geekbrains.SpringHW5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHw5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringHw5Application.class, args);
	}

}
/*
Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA.
Требуется реализовать следующие функции:

Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере:
@GetMapping("/status/{status}") public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
Изменение статуса задачи. Подсказка метод в контроллере: @PutMapping("/{id}")
public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
Удаление задачи.
Подсказка метод в контроллере: @DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id)

Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long>

 */