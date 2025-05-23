import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int inputValue;
    private final int expectedResult;

    public FelineParamTest(int inputValue, int expectedResult) {
        this.inputValue = inputValue;
        this.expectedResult = expectedResult;
    }

    @Parameters(name="Параметры {index}: вход={0}, выход={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {3, 3},
                {5, 5}
        });
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals(expectedResult, feline.getKittens(inputValue));
    }
}
