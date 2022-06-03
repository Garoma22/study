package Part1.DigitsAndStrings.GeometryCalculator;

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {

        return Math.pow((Math.PI * radius), 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return 4 / 3 * Math.PI * Math.pow(radius, 3);
    }

    public static double isTriangleRightAngled(double a, double b, double c) {

        if (a + b > c) {
            if (a + c > b) {
                if (b + c > a) {
                    System.out.println("Треугольник существует");
                }
            }
        } else {
            return -1.0;
        }

        return 1.0;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {

        double p = (a + b + c) / 2;

        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return s;
    }
}
