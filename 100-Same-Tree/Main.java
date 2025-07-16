public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: p = [1,2,3], q = [1,2,3]
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Test 1 (Expected: true): " + solution.isSameTree(p1, q1));

        // Example 2: p = [1,2], q = [1,null,2]
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("Test 2 (Expected: false): " + solution.isSameTree(p2, q2));

        // Example 3: p = [1,2,1], q = [1,1,2]
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println("Test 3 (Expected: false): " + solution.isSameTree(p3, q3));

        // Test 4: Both null
        System.out.println("Test 4 (Expected: true): " + solution.isSameTree(null, null));

        // Test 5: One null, one non-null
        TreeNode p5 = new TreeNode(0);
        System.out.println("Test 5 (Expected: false): " + solution.isSameTree(p5, null));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
