
import java.util.Scanner;

public class application_questionnaire {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lastName = askLastName();
        String firstName = askFirstName();

        boolean schoolCertificate = askSchoolCertificate();
        if (!schoolCertificate) {
            System.out.println("You cannot be admitted to AIU.");
            return;
        }

        int ORTscore = askORTscore();
        if (ORTscore < 110) {
            System.out.println("You cannot be admitted to AIU.");
            return;
        }

        int englishProficiency = askEnglishProficiency();
        if (englishProficiency < 3) {
            System.out.println("""
                               You cannot be admitted to AIU this year, but can enroll the Foundation course.
                               Do you want to enroll the Foundation course? (choose one):""");
            System.out.println("""
                               1. YES
                               2. NO""");

            int choice = sc.nextInt();
            if (choice == 1 || choice == 2) {
                System.out.println("OK"); 
            }else {
                System.out.println("INVALID");
            }
            return;
        }

        clearScreen();
        System.out.println("Everything is OK, your application is recommended to AIU.");
        clearScreen();

        specialitiesMenu();
        int specialty = sc.nextInt();
        int discount = discountCalc(ORTscore);
        int tuition = tuitionCalc(specialty, discount);
        clearScreen();
        if (discount != 0) {
            System.out.print("Dear " + firstName + " " + lastName + " we congratulate you!\n"
                    + "You have been admitted to the " + applicantProgram(specialty)
                    + " at Ala-Too International University.\n"
                    + "The cost of your tuition with a " + discount + "% discount will be "
                    + tuition + "$ per year."); 
        }else {
            System.out.print("Dear " + firstName + " " + lastName + " we congratulate you!\n"
                    + "You have been admitted to the " + applicantProgram(specialty)
                    + " at Ala-Too International University.\n"
                    + "The cost of your tuition will be " + tuition + "$ per year.");
        }
    }

    @SuppressWarnings("resource")
    public static String askFirstName() {
        System.out.println("Enter your first name:");
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.nextLine();
        return name;
    }

    @SuppressWarnings("resource")
    public static String askLastName() {
        System.out.println("Enter your last name:");
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.nextLine();
        return name;
    }

    @SuppressWarnings("resource")
    public static boolean askSchoolCertificate() {
        System.out.println("Do you have a school education certificate? (choose one):");
        System.out.println("""
                           1. YES
                           2. NO""");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        return choice == 1;
    }

    @SuppressWarnings("resource")
    public static int askEnglishProficiency() {
        System.out.println("Enter your english proficiency (choose one):");
        System.out.print("""
                         1. A1
                         2. A2
                         3. B1
                         4. B2
                         5. C1
                         6. C2
                         """);
        int proficiency;
        Scanner sc = new Scanner(System.in);
        proficiency = sc.nextInt();
        return proficiency;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @SuppressWarnings("resource")
    public static int askORTscore() {
        System.out.println("Enter your ORT score:");
        Scanner sc = new Scanner(System.in);
        int score;
        score = sc.nextInt();
        return score;
    }

    public static void specialitiesMenu() {
        System.out.println("Choose your speciality:");
        System.out.println("""
                           1. Computer Engineering (2500$)
                           2. Artificial Intelligence (2200$)
                           3. Psychology (1900$)
                           4. Journalism (1700$)
                           5. International Relations (2200$)
                           6. Law (1800$)
                           7. Management (2200$)
                           8. Medicine (3300$)""");
    }

    public static int discountCalc(int ort) {
        if (ort > 245) {
            return 0;
        }
        if (ort >= 219) {
            return 100;
        }
        if (ort >= 210) {
            return 75;
        }
        if (ort >= 200) {
            return 50;
        }
        if (ort >= 175) {
            return 25;
        }
        if (ort >= 156) {
            return 10;
        }
        if (ort >= 140) {
            return 5;
        }
        return 0;
    }

    public static int tuitionCalc(int specialty, int discount) {
        int fullTuition = 0;
        switch (specialty) {
            case 1 ->
                fullTuition = 2500;
            case 2 ->
                fullTuition = 2200;
            case 3 ->
                fullTuition = 1900;
            case 4 ->
                fullTuition = 1700;
            case 5 ->
                fullTuition = 2200;
            case 6 ->
                fullTuition = 1800;
            case 7 ->
                fullTuition = 2200;
            case 8 ->
                fullTuition = 3300;
            default -> {
            }
        }
        return fullTuition - (fullTuition / 100 * discount);
    }

    public static String applicantProgram(int specialty) {
        return switch (specialty) {
            case 1 ->
                "Computer Engineering";
            case 2 ->
                "Artificial Intelligence";
            case 3 ->
                "Psychology";
            case 4 ->
                "Journalism";
            case 5 ->
                "International Relations";
            case 6 ->
                "Law";
            case 7 ->
                "Management";
            case 8 ->
                "Medicine";
            default ->
                "Nothing";
        };
    }
}
