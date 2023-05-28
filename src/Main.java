public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(MathGeneration.generateEquation(MathGeneration.generateNumber(100, 1000), 3, MathGeneration.generateNumber(10, 100), 1, "/"));
        }
    }
}
