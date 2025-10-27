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

    public static void combinationStartWithNo(String solution, String remaining, int k) {
      if (solution.length() == k) {
          System.out.println(solution);
      } else if(remaining.equals("")) {
  	    return;
      } else {
  	    String ch = remaining.substring(remaining.length() - 1, remaining.length());
  	    remaining = remaining.substring(0, remaining.length() - 1);
  	    combinationStartWithNo(solution, remaining, k);
  	    solution += ch;
  	    combinationStartWithNo(solution, remaining, k);
      }
    }
    
    public static void combinationStartWithYes(String solution, String remaining, int k) {
      if (solution.length() == k){
        System.out.println(solution);
      } else if (remaining.equals("")){
        return;
      } else {
        char ch = remaining.charAt(0);
        remaining = remaining.substring(1);
        solution = solution + ch;
        combinationStartWithYes(solution, remaining, k);
        solution = solution.substring(0, remaining.length() - 1);
        combinationStartWithYes(solution, remaining, k);
      }
    }


    public static void main(String[] args) {
      if (args.length != 1) {
        System.out.println("Usage: java WordList yourword");
          return;
        }

	      /*
        String word = args[0];
        List<String> results = new ArrayList<>();  // ? this defines 'results'

        permutation("", word, results);

        System.out.println("All permutations of " + word + ":");
        System.out.println(results);
	      */

    	String word = args[0];
    	int k = 2;
    	System.out.println("All combinations of " + word + " starting with no");
      combinationStartWithNo("", word, k);
     
      System.out.println("All combinations of " + word + " starting with yes");
      combinationStartWithYes("", word, k);
    }
}
