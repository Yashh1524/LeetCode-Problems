// Main.java

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        head1 = sol.removeNthFromEnd(head1, 2);
        printList(head1); // Output: 1 -> 2 -> 3 -> 5

        // Test Case 2
        ListNode head2 = createList(new int[]{1});
        head2 = sol.removeNthFromEnd(head2, 1);
        printList(head2); // Output: (empty)

        // Test Case 3
        ListNode head3 = createList(new int[]{1, 2});
        head3 = sol.removeNthFromEnd(head3, 1);
        printList(head3); // Output: 1
    }

    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb);
    }
}
