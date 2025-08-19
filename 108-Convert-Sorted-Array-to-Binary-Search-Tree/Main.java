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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2; // avoids overflow
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, l, mid - 1);
        root.right = buildBST(nums, mid + 1, r);
        return root;
    }
}

public class Main {
    // Helper: level-order traversal (to verify structure like LeetCode)
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                result.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            } else {
                result.add(null); // represent missing nodes like LeetCode output
            }
        }

        // Trim trailing nulls (LeetCode does this in serialization)
        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i);
            i--;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = sol.sortedArrayToBST(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Level-order Output: " + levelOrder(root1));

        // Test case 2
        int[] nums2 = {1, 3};
        TreeNode root2 = sol.sortedArrayToBST(nums2);
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Level-order Output: " + levelOrder(root2));

        // Test case 3
        int[] nums3 = {0, 1, 2, 3, 4, 5, 6};
        TreeNode root3 = sol.sortedArrayToBST(nums3);
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Level-order Output: " + levelOrder(root3));
    }
}
