import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

public class LionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private Feline mockFeline;

    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lionMale = new Lion("Самец", mockFeline);
        lionFemale = new Lion("Самка", mockFeline);
    }


    @Test
    public void testDoesHaveManeForMale() {
        assertTrue(lionMale.doesHaveMane());
    }


    @Test
    public void testDoesNotHaveManeForFemale() {
        assertFalse(lionFemale.doesHaveMane());
    }


    @Test
    public void testInvalidSexThrowsException() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        new Lion("Неправильный пол", mockFeline);
    }


    @Test
    public void testGetFood() throws Exception {
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Добыча"));
        List<String> food = lionMale.getFood();
        assertEquals(List.of("Добыча"), food);
    }


    @Test
    public void testGetKittensDefault() {
        assertEquals(0, lionMale.getKittens());
    }
}