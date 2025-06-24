public class Main {

    // Definition for singly-linked list.
    static class ListNode {
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

    // Solution class (your code)
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = head;
            if (head == null || head.next == null) {
                return head;
            }
            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return head;
        }
    }

    // Helper: build linked list from array
    public static ListNode buildList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper: print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null)
                System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Main function with test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] testCases = {
                { 1, 1, 2 },
                { 1, 1, 2, 3, 3 },
                { 1, 2, 3 },
                { 1, 1, 1 },
                {},
                { 1 }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            ListNode head = buildList(testCases[i]);
            System.out.print("Input: ");
            printList(head);
            ListNode result = solution.deleteDuplicates(head);
            System.out.print("Output: ");
            printList(result);
            System.out.println();
        }
    }
}
