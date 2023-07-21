package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() { //добавляет в менеджер задачи
        SimpleTasks simpleTask = new SimpleTasks(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhereHaveMatch() { //выводит задачи, где есть совпадения, если они есть
        SimpleTasks simpleTask = new SimpleTasks(87, "Помыть окна");

        String[] subtasks = {"Купить картошку", "Отнести ноутбук в ремонт"};
        Epic epic = new Epic(68, subtasks);

        Meeting meeting = new Meeting(73, "Разработка технической документации", "ноутбук 10", "26 августа");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("ноутбук");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhereDoNotHaveMatch() { //не выводит ничего, если нет совпадений
        SimpleTasks simpleTask = new SimpleTasks(87, "Помыть окна");

        String[] subtasks = {"Купить картошку", "Отнести ноутбук в ремонт"};
        Epic epic = new Epic(68, subtasks);

        Meeting meeting = new Meeting(73, "Разработка технической документации", "ноутбук 10", "26 августа");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("цветы");
        Assertions.assertArrayEquals(expected, actual);
    }
}
