/**
 * @URL: https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedList {
    /**
     * Time : O(m + n)
     * Space: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Compute the length of both the lists.
        int len1 = getLength(headA);
        int len2 = getLength(headB);

        // Always make first list longer in length. If not already swap with second list.
        if (len1 <= len2) {
            ListNode temp1 = headA;
            headA = headB;
            headB = temp1;

            int temp2 = len1;
            len1 = len2;
            len2 = temp2;
        }

        // Move list A forward with the difference in nodes and make both lists of equal length
        int diff = len1 - len2;
        while (diff-- > 0) {
            headA = headA.next;
        }

        // Now iterate until both the arrays are not equal.
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode headA) {
        int len = 0;
        while (headA != null) {
            ++len;
            headA = headA.next;
        }
        return len;
    }
}
