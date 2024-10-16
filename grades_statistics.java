
import java.util.Scanner;

public class grades_statistics {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfGrades = sc.nextInt();
        int[] grades = new int[numberOfGrades];
        for (int i = 0; i < numberOfGrades; i++) {
            grades[i] = sc.nextInt();
        }

        int[] convertedGrades = classifyGrades(grades);
        for (int i = 0; i < convertedGrades.length; i++) {
            System.out.println(abcGrade(i) + ": " + convertedGrades[i]
                    + (convertedGrades[i] == 1 ? " grade " : " grades ")
                    + "(" + Math.round((double) convertedGrades[i] * 100 / numberOfGrades) + "%)");
        }
    }

    public static int[] classifyGrades(int[] grades) {
        int[] convertedGrades = new int[5];
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            if (grade >= 90) {
                convertedGrades[0]++; 
            }else if (grade >= 75) {
                convertedGrades[1]++; 
            }else if (grade >= 60) {
                convertedGrades[2]++; 
            }else if (grade >= 50) {
                convertedGrades[3]++; 
            }else {
                convertedGrades[4]++;
            }
        }
        return convertedGrades;
    }

    public static char abcGrade(int grade) {
        switch (grade) {
            case 0 -> {
                return 'A';
            }
            case 1 -> {
                return 'B';
            }
            case 2 -> {
                return 'C';
            }
            case 3 -> {
                return 'D';
            }
            case 4 -> {
                return 'F';
            }
        }
        return '0';
    }
}
