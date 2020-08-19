import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @DisplayName("01 Test add")
    @Test
    void add() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected,actual);

    }
}