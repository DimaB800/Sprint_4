import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class checkNameToEmbossParameterizedTest {
    private final String name;
    private final boolean expected;

    public checkNameToEmbossParameterizedTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"Карина Герасиченко", true},
                {"Анжелика Клемнова", true},
                {"SE l", true},
                {"D F", true},
                {"Нулл Лунн", true},
                {"Петров", false},
                {" Ivanov", false},
                {"Сидоров ", false},
                {"X ", false},
                {"", false},
                {" ", false},
                {"Garetbnnx cncnnncnnf", false},
                {"fjnvnvnjna vvтмовмттшшшшш ", false},
                {"Карина  Герасиченко", false},

        };
    }

    @Test
    public void main() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}