import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: root = [1,null,2,3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        List<Integer> expected1 = Arrays.asList(1, 3, 2);
        testInorderTraversal(solution, root1, expected1);

        // Example 2: root = [1,2,3,4,5,null,8,null,null,6,7,9]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.right.left = new TreeNode(6);
        root2.left.right.right = new TreeNode(7);
        root2.right.right = new TreeNode(8);
        root2.right.right.left = new TreeNode(9);
        List<Integer> expected2 = Arrays.asList(4, 2, 6, 5, 7, 1, 3, 9, 8);
        testInorderTraversal(solution, root2, expected2);

        // Example 3: root = []
        TreeNode root3 = null;
        List<Integer> expected3 = Collections.emptyList();
        testInorderTraversal(solution, root3, expected3);

        // Example 4: root = [1]
        TreeNode root4 = new TreeNode(1);
        List<Integer> expected4 = Arrays.asList(1);
        testInorderTraversal(solution, root4, expected4);

        System.out.println("All test cases passed!");
    }

    private static void testInorderTraversal(Solution solution, TreeNode root, List<Integer> expected) {
        List<Integer> result = solution.inorderTraversal(root);
        assert result.equals(expected) : "Expected " + expected + ", but got " + result;
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Solution class with iterative inorder traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }
}
