import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


/*
20
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Test passed");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    @DisplayName("01 Test add")
    void addTest() {

        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);
    }

    @EnabledOnJre(JRE.JAVA_10)
    @Test
    @DisplayName("02 Test Array")
    void arrTest() {
        int[] expected = {1, 2, 3, 4};
        int[] actual = mathUtils.arr(1, 2, 3, 4);
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("03 Test Circle")
    void computeCircleAreaTest() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                "Should return right circle area");
    }

    @Test
    @DisplayName("04 Test Divide")
    void divideTest() {
        boolean value = true;
        assumeTrue(value);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide by zero should be throw");
    }

    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    void testDisabled() {
        fail("This test should be disabled");
    }

}