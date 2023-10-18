import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

    Epic epic = new Epic(55, subtasks);

    @Test
    public void simpleTaskShouldMatchQuery() {
        String query = "Позвонить";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskShouldNotMatchQuery() {
        String query = "Кракозябра";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingShouldMatchQueryByTopic() {
        String query = "3";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingShouldMatchQueryByProject() {
        String query = "Нето";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingShouldNotMatchQuery() {
        String query = "Кракозябра";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicShouldMatchQuery() {
        String query = "Хлеб";

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicShouldNotMatchQuery() {
        String query = "Кракозябра";

        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}
