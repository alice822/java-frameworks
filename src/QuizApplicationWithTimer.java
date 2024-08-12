import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplicationWithTimer {
    private static final int TIMER_DELAY = 10000; // 10 seconds for each question
    private static int score = 0;
    private static int questionIndex = 0;
    private static boolean timeUp = false;

    private static String[][] questions = {
            {"What is the capital of France?", "A) Berlin", "B) London", "C) Paris", "D) Madrid", "C"},
            {"What is the largest planet in our solar system?", "A) Earth", "B) Jupiter", "C) Mars", "D) Venus", "B"},
            {"What is the chemical symbol for water?", "A) H2O", "B) CO2", "C) NaCl", "D) O2", "A"},
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (questionIndex = 0; questionIndex < questions.length; questionIndex++) {
            timeUp = false;

            System.out.println("Question " + (questionIndex + 1) + ":");
            for (int j = 0; j < 5; j++) {
                System.out.println(questions[questionIndex][j]);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                }
            }, TIMER_DELAY);

            String userAnswer = scanner.nextLine();
            timer.cancel();

            if (!timeUp) {
                if (userAnswer.equalsIgnoreCase(questions[questionIndex][5])) {
                    score++;
                }
            }
        }

        System.out.println("Quiz over!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        scanner.close();
    }
}
