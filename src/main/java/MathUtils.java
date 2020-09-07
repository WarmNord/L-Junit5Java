import javafx.beans.binding.Bindings;

import java.util.*;

import static java.lang.Math.PI;

public class MathUtils {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }



    public int[] arr(int a, int b, int c, int d) {
        return new int[]{a, b, c, d};
    }

    public double computeCircleArea(double radius) {
        return PI * radius * radius;
    }

}
