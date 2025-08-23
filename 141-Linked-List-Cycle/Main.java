class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static ListNode createLinkedList(int[] values, int pos) {
        if (values.length == 0)
            return null;

        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        ListNode cycleNode = null;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
            if (i == pos) {
                cycleNode = curr;
            }
        }

        if (pos >= 0) {
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            if (pos == 0) {
                cycleNode = head;
            }
            tail.next = cycleNode;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: [3,2,0,-4], pos = 1 → true
        ListNode head1 = createLinkedList(new int[] { 3, 2, 0, -4 }, 1);
        System.out.println(sol.hasCycle(head1)); // true

        // Test case 2: [1,2], pos = 0 → true
        ListNode head2 = createLinkedList(new int[] { 1, 2 }, 0);
        System.out.println(sol.hasCycle(head2)); // true

        // Test case 3: [1], pos = -1 → false
        ListNode head3 = createLinkedList(new int[] { 1 }, -1);
        System.out.println(sol.hasCycle(head3)); // false

        // Extra Test case 4: Empty list → false
        ListNode head4 = createLinkedList(new int[] {}, -1);
        System.out.println(sol.hasCycle(head4)); // false
    }
}
