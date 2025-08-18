import java.util.*;

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

class Solution {
    // Recursive approach
    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) &&
               isMirror(p.left, q.right) &&
               isMirror(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // Iterative approach using Queue
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            if (p == null && q == null) continue;
            if (p == null || q == null || p.val != q.val) return false;

            // push children in mirror order
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: Symmetric tree
        TreeNode root1 = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        // Example 2: Not symmetric
        TreeNode root2 = new TreeNode(1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(3))
        );

        // Single node tree (symmetric)
        TreeNode root3 = new TreeNode(1);

        System.out.println("Recursive approach:");
        System.out.println("Example 1 (Expected: true): " + sol.isSymmetric(root1));
        System.out.println("Example 2 (Expected: false): " + sol.isSymmetric(root2));
        System.out.println("Single node (Expected: true): " + sol.isSymmetric(root3));

        System.out.println("\nIterative approach:");
        System.out.println("Example 1 (Expected: true): " + sol.isSymmetricIterative(root1));
        System.out.println("Example 2 (Expected: false): " + sol.isSymmetricIterative(root2));
        System.out.println("Single node (Expected: true): " + sol.isSymmetricIterative(root3));
    }
}
