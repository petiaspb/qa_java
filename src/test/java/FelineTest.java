import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FelineTest {


    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expectedList, feline.eatMeat());
    }


    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }


    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }


    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }
}
