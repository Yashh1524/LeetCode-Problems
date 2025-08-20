import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Solution with recursive preorder
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;        
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }    
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: root = [1,null,2,3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println("Example 1 Output: " + sol.preorderTraversal(root1)); // [1,2,3]

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
        System.out.println("Example 2 Output: " + sol.preorderTraversal(root2)); // [1,2,4,5,6,7,3,8,9]

        // Example 3: root = []
        TreeNode root3 = null;
        System.out.println("Example 3 Output: " + sol.preorderTraversal(root3)); // []

        // Example 4: root = [1]
        TreeNode root4 = new TreeNode(1);
        System.out.println("Example 4 Output: " + sol.preorderTraversal(root4)); // [1]
    }
}
