import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;

public class CatTest {

    @Mock
    private Feline mockFeline;

    private Cat cat;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Жертва"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Жертва"), food);
    }
}