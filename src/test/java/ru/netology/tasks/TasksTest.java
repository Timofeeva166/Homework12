package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldGetSimpleTasksData() { //Получает данные simpleTask
        SimpleTasks simpleTask = new SimpleTasks(6, "Навестить друга");

        Assertions.assertEquals(6, simpleTask.getId());
        Assertions.assertEquals("Навестить друга", simpleTask.getTitle());
    }

    @Test
    public void shouldGetEpicData() { //получает данные Epic
        String[] subtasks = {"Купить утюг", "Приготовить салат"};
        Epic epic = new Epic(8, subtasks);

        Assertions.assertEquals(8, epic.getId());
        String[] expected = {"Купить утюг", "Приготовить салат"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMeetingData() { //получает данные Meeting
        Meeting meeting = new Meeting(29, "Внедрение автотестов", "Умный дом", "18 сентября");

        Assertions.assertEquals(29, meeting.getId());
        Assertions.assertEquals("Внедрение автотестов", meeting.getTopic());
        Assertions.assertEquals("Умный дом", meeting.getProject());
        Assertions.assertEquals("18 сентября", meeting.getStart());
    }

    @Test
    public void testSimpleTasksMatches() { //проверяет совпадения в SimpleTask
        SimpleTasks simpleTask = new SimpleTasks(7,"Помыть машину");

        Assertions.assertEquals(true, simpleTask.matches("машину")); //есть совпадения в title
        Assertions.assertEquals(false, simpleTask.matches("цветы")); //нет совпадений в title
    }

    @Test
    public void testEpicMatches() { //проверяет совпадения в Epic
        String[] subtasks = {"покормить кота", "постирать бельё", "полить цветы"};
        Epic epic = new Epic(33, subtasks);

        Assertions.assertEquals(true, epic.matches("цветы")); //есть совпадения в subtasks
        Assertions.assertEquals(false, epic.matches("машину")); //нет совпадений в subtasks
    }

    @Test
    public void testMeetingMatches() { //проверяет совпадения в Meeting
        Meeting meeting = new Meeting(44,
                "Тестирование новой версии приложения",
                "Электронный дневник",
                "22 октября");

        Assertions.assertEquals(true, meeting.matches("Тестирование")); //есть совпадение в topic
        Assertions.assertEquals(true, meeting.matches("дневник")); //есть совпадение в project
        Assertions.assertEquals(false, meeting.matches("машину")); //нет совпадений

    }

}
