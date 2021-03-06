import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


/*
27
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;


    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " tags " + testInfo.getTags());

    }

    @AfterEach
    void cleanUp() {
        System.out.println("Test passed");
    }

    @Nested
    @DisplayName("Test Add")
    @Tag("Math")
    class addTest {
        @Test
        @DisplayName("Test add +")
        void addTestPositive() {

            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test add -")
        void addTestNegative() {

            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            assertEquals(expected, actual, () ->"should return" + expected +
                    "but return" + actual);
        }
    }


    @Test
    @DisplayName("Test Array")
    void arrTest() {
        int[] expected = {1, 2, 3, 4};
        int[] actual = mathUtils.arr(1, 2, 3, 4);
        assertArrayEquals(expected, actual);
    }

    @RepeatedTest(3)
    @DisplayName("Test Circle")
    void computeCircleAreaTest(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition());
        System.out.println(repetitionInfo.getTotalRepetitions());
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                "Should return right circle area");
    }

    @Test
    @DisplayName("Multiply method")
    @Tag("Math")
    void multiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(2, mathUtils.multiply(-2, -1))
        );

    }

    @Test
    @DisplayName("Test Divide")
    @Tag("Math")
    void divideTest() {
        boolean value = true;
        assumeTrue(value);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide by zero should be throw");
    }

    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    @Tag("disabled")
    void testDisabled() {
        fail("This test should be disabled");
    }

}