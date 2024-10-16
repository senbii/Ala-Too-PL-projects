
import java.util.Scanner;

public class login_password {

    public static void main(String[] args) {
        String correctLogin = "17", correctPassword = "17";

        String userLogin = getLogin(), userPassword = getPassword();
        int counter = 1;
        while (!userLogin.equals(correctLogin) || !userPassword.equals(correctPassword)) {
            clearScreen();
            System.out.println("Wrong login or password");
            userLogin = getLogin();
            userPassword = getPassword();

            counter++;
            if (counter == 3) {
                counter = 0;
                System.out.println("You have entered incorrect login or password 3 times. "
                        + "Wait 5 seconds to try again.");
                wait(5000);
            }
        }
        System.out.println("You successfully logged in!");

    }

    @SuppressWarnings("resource")
    public static String getLogin() {
        System.out.println("Enter your login:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @SuppressWarnings("resource")
    public static String getPassword() {
        System.out.println("Enter your password:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
