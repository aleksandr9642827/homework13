import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Приложение готово");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Приложение"};

    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldAddThreeTasksDifferentType() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMacheAllTask() {
        String query = "Приложение";

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotMacheAllTask() {
        String query = "Кракозябра";

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }
}
