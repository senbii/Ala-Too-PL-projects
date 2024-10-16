
import java.util.Scanner;

public class calculator {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();

        menu();
        int operation = sc.nextInt();
        clearScreen();
        switch (operation) {
            case 1 -> {
                int mul = multiply(a, b);
                System.out.print(a + " * " + b + " = " + mul);
            }
            case 2 -> {
                double div = divide(a, b);
                if (b != 0) {
                    System.out.print(a + " / " + b + " = " + String.format("%.3f", div));
                }
            }
            case 4 -> {
                int sum = add(a, b);
                System.out.print(a + " + " + b + " = " + sum);
            }
            case 3 -> {
                int sub = subtract(a, b);
                System.out.print(a + " - " + b + " = " + sub);
            }
            default ->
                System.out.print("Invalid operation.");
        }

    }

    public static void menu() {
        System.out.print("""
                         1- Multiplication
                         2- Division
                         3- Subtraction
                         4- Addition
                         """);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.print("nuh-uh cannot divide by zero");
            return 0;
        }
        return (double) a / b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
