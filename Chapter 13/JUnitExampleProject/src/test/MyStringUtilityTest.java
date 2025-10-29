import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyStringUtilityTest {

    @Test
    void testReverseString() {
        String result = MyStringUtilityTest.reverse("matrix");
                assertEquals("xirtam", result, "Reversed string should be 'xirtam'");
            }
}
