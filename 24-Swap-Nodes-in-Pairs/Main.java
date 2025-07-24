public class Main {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Solution class with swapPairs implementation
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode temp = dummy;

            while (temp.next != null && temp.next.next != null) {
                ListNode cur = temp.next;
                ListNode next = temp.next.next;
                cur.next = next.next;
                next.next = cur;
                temp.next = next;

                temp = cur;
            }

            return dummy.next;
        }
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: [1, 2, 3, 4]
        ListNode head1 = createList(new int[]{1, 2, 3, 4});
        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = solution.swapPairs(head1);
        System.out.print("Swapped : ");
        printList(result1);
        System.out.println();

        // Test case 2: []
        ListNode head2 = createList(new int[]{});
        System.out.print("Original: ");
        printList(head2);
        ListNode result2 = solution.swapPairs(head2);
        System.out.print("Swapped : ");
        printList(result2);
        System.out.println();

        // Test case 3: [1]
        ListNode head3 = createList(new int[]{1});
        System.out.print("Original: ");
        printList(head3);
        ListNode result3 = solution.swapPairs(head3);
        System.out.print("Swapped : ");
        printList(result3);
        System.out.println();

        // Test case 4: [1, 2, 3]
        ListNode head4 = createList(new int[]{1, 2, 3});
        System.out.print("Original: ");
        printList(head4);
        ListNode result4 = solution.swapPairs(head4);
        System.out.print("Swapped : ");
        printList(result4);
    }
}
