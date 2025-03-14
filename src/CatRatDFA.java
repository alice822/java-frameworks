import java.util.Scanner;

public class CatRatDFA {
    private static final int INITIAL_STATE = 0;
    private static final int FINAL_STATE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.nextLine().toLowerCase();

        boolean accepted = runDFA(input);

        if (accepted) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }

        scanner.close();
    }

    private static boolean runDFA(String input) {
        int currentState = INITIAL_STATE;

        for (char c : input.toCharArray()) {
            switch (currentState) {
                case 0:
                    if (c == 'c' || c == 'r') {
                        currentState = 1;
                    } else {
                        return false;
                    }
                    break;
                case 1:
                    if (c == 'a') {
                        currentState = 2;
                    } else {
                        return false;
                    }
                    break;
                case 2:
                    if (c == 't') {
                        currentState = FINAL_STATE;
                    } else {
                        return false;
                    }
                    break;
                case FINAL_STATE:
                    return false; // Any additional characters after reaching the final state
            }
        }

        return currentState == FINAL_STATE;
    }
}