import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Test Case 1: " + Arrays.toString(candidates1) + " Target: " + target1);
        printResult(sol.combinationSum(candidates1, target1)); 
        // Expected: [[2, 2, 3], [7]]

        // Test Case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Test Case 2: " + Arrays.toString(candidates2) + " Target: " + target2);
        printResult(sol.combinationSum(candidates2, target2)); 
        // Expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        // Test Case 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("Test Case 3: " + Arrays.toString(candidates3) + " Target: " + target3);
        printResult(sol.combinationSum(candidates3, target3)); 
        // Expected: []

        // Test Case 4 (Extra)
        int[] candidates4 = {2, 4, 8};
        int target4 = 8;
        System.out.println("Test Case 4: " + Arrays.toString(candidates4) + " Target: " + target4);
        printResult(sol.combinationSum(candidates4, target4)); 
        // Expected: [[2, 2, 2, 2], [2, 2, 4], [4, 4], [8]]
    }

    // Helper to print result lists
    public static void printResult(List<List<Integer>> result) {
        System.out.println(result);
        System.out.println("--------------");
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        makeCombination(candidates, target, 0, new ArrayList<>(), 0, res);
        return res;        
    }

    private void makeCombination(int[] candidates, int target, int idx, List<Integer> comb, int total, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if (total > target || idx >= candidates.length) {
            return;
        }
        comb.add(candidates[idx]);
        makeCombination(candidates, target, idx, comb, total + candidates[idx], res);
        comb.remove(comb.size() - 1);
        makeCombination(candidates, target, idx + 1, comb, total, res);
    }    
}
