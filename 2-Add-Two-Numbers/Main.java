class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return res.next;
    }
}

public class Main {
    // Helper to create a linked list from array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = createList(new int[] { 2, 4, 3 });
        ListNode l2 = createList(new int[] { 5, 6, 4 });
        System.out.print("Output 1: ");
        printList(sol.addTwoNumbers(l1, l2)); // [7, 0, 8]

        // Example 2: l1 = [0], l2 = [0]
        l1 = createList(new int[] { 0 });
        l2 = createList(new int[] { 0 });
        System.out.print("Output 2: ");
        printList(sol.addTwoNumbers(l1, l2)); // [0]

        // Example 3: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        l1 = createList(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        l2 = createList(new int[] { 9, 9, 9, 9 });
        System.out.print("Output 3: ");
        printList(sol.addTwoNumbers(l1, l2)); // [8,9,9,9,0,0,0,1]
    }
}
