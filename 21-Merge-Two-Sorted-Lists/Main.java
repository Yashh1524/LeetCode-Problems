class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Normal merge
        ListNode list1 = buildList(new int[]{1, 2, 4});
        ListNode list2 = buildList(new int[]{1, 3, 4});
        printList(sol.mergeTwoLists(list1, list2)); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4

        // Test Case 2: Both lists empty
        list1 = buildList(new int[]{});
        list2 = buildList(new int[]{});
        printList(sol.mergeTwoLists(list1, list2)); // Expected: (empty)

        // Test Case 3: One list empty, other has elements
        list1 = buildList(new int[]{});
        list2 = buildList(new int[]{0});
        printList(sol.mergeTwoLists(list1, list2)); // Expected: 0

        // Test Case 4: Different lengths
        list1 = buildList(new int[]{1, 5, 9});
        list2 = buildList(new int[]{2, 3, 7, 10});
        printList(sol.mergeTwoLists(list1, list2)); // Expected: 1 -> 2 -> 3 -> 5 -> 7 -> 9 -> 10
    }

    // Helper method to build a linked list from an array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}
