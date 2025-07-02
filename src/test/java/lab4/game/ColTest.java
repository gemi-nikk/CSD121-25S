package lab4.game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColTest {

    @Test
    void testValidLowercaseInput() {
        assertEquals(Col.Left, Col.from("l"));
        assertEquals(Col.Middle, Col.from("m"));
        assertEquals(Col.Right, Col.from("r"));
    }

    @Test
    void testValidUppercaseInput() {
        assertEquals(Col.Left, Col.from("L"));
        assertEquals(Col.Middle, Col.from("M"));
        assertEquals(Col.Right, Col.from("R"));
    }

    @Test
    void testCaseInsensitive() {
        assertEquals(Col.Left, Col.from("L"));
        assertEquals(Col.Left, Col.from("l"));
    }
}
