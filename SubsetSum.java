import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    public static void findAllSubsetSums(List<Integer> nums, int target, List<Integer> subset, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(subset));
            return;
        }

        if (nums.isEmpty() || target < 0) {
            return;
        }

        int n = nums.get(0);
        List<Integer> remaining = new ArrayList<>(nums.subList(1, nums.size()));

        // Include current number
        subset.add(n);
        findAllSubsetSums(remaining, target - n, subset, results);
        subset.remove(subset.size() - 1);

        // Exclude current number
        findAllSubsetSums(remaining, target, subset, results);
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 34, 4, 12, 5, 2));
        int target = 9;
        List<List<Integer>> results = new ArrayList<>();

        findAllSubsetSums(nums, target, new ArrayList<>(), results);

        if (results.isEmpty()) {
            System.out.println("No subsets found");
        } else {
            System.out.println("All subsets that sum to " + target + ":");
            System.out.println(results);
        }
    }
}
