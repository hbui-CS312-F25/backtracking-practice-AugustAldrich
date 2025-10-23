import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination{

    public static ArrayList<String> copy(ArrayList<String> source) {
        ArrayList<String> destination = new ArrayList<>();
        for (String s : source) {
            destination.add(s);
        }
        return destination;
    }

    public static void combination(ArrayList<String> solution, ArrayList<String> remaining, int k, List<List<String>> results) {
        if (solution.size() == k) {
            results.add(new ArrayList<>(solution));
            return;
        }
        if (remaining.size() == 0) {
            return;
        }

        String name = remaining.remove(0);

        ArrayList<String> newRemaining = copy(remaining);
        ArrayList<String> newSolution = copy(solution);
        combination(newSolution, newRemaining, k, results);

        newRemaining = copy(remaining);
        newSolution = copy(solution);
        newSolution.add(name);
        combination(newSolution, newRemaining, k, results);
    }

    public static void main(String[] args) {
        String[] names = {"Roberts", "Thomas", "Alito", "Sotomayor", "Kagan", "Gorsuch", "Kavanaugh", "Barrett", "Jackson"};

        ArrayList<String> justices = new ArrayList<>(Arrays.asList(names));
        ArrayList<String> majority = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();

        combination(majority, justices, 5, results);

        System.out.println("Total combinations: " + results.size());
        System.out.println("Example combinations: " + results.subList(0, 5)); // print first 5
    }
}
