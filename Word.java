import java.util.ArrayList;
import java.util.List;

public class Word {

    public static void permutation(String solution, String remaining, List<String> results) {
        if (remaining.length() == 0) {
            results.add(solution);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                char ch = remaining.charAt(i);
                String nextRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                String nextSolution = solution + ch;
                permutation(nextSolution, nextRemaining, results);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WordList yourword");
            return;
        }

        String word = args[0];
        List<String> results = new ArrayList<>();  // ? this defines 'results'

        permutation("", word, results);

        System.out.println("All permutations of " + word + ":");
        System.out.println(results);
    }
}
