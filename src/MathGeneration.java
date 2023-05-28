import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MathGeneration {
    public static double generateNumber(int from, int to) {
        return Math.random() * (to - from) + from;
    }

    public static String format(double value, String pattern) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(value);
    }

    public static String format(double value, int scale) {
        return new BigDecimal(value).setScale(scale, RoundingMode.DOWN).toString();
    }

    public static String format(double value1, int scale1, double value2, int scale2) {
        BigDecimal v1 = BigDecimal.valueOf(value1).setScale(scale1, RoundingMode.DOWN);
        BigDecimal v2 = BigDecimal.valueOf(value2).setScale(scale2, RoundingMode.DOWN);
        BigDecimal v3 = v1.divide(v2, scale1 - scale2, RoundingMode.DOWN);
        BigDecimal v4 = v3.multiply(v2).setScale(scale1, RoundingMode.DOWN);
        return v4.toString();
    }

    public static String generateEquation(String value1, String value2, String operator) {
        return value1 + " " + operator + " " + value2 + " =";
    }

    public static String generateEquation(double value1, int pattern1, double value2, int pattern2, String operator) {
        switch (operator) {
            case "-":
                if (value1 < value2) {
                    return generateEquation(value2, pattern2, value1, pattern1, operator);
                }
            case "x":
            case "+":
                return generateEquation(format(value1, pattern1), format(value2, pattern2), operator);
            case "/":
                return generateEquation(format(value1, pattern1, value2, pattern2), format(value2, pattern2), operator);
            default:
                return generateEquation(format(value1, pattern1), format(value2, pattern2), operator);
        }
    }
}
