package link.list;

import java.util.HashSet;
import java.util.Set;


public class LinkCycleCheck {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node5.Next = node2;

        System.out.println(hasCycle(node1));

        System.out.println(hasCycle1(node1));
    }

    //Set无序不重复 T:O(n) S:O(n)
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.add(head) == false) {
                return true;
            }
            head = head.Next;
        }

        return false;
    }

    //双指针
    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.Next == null)
            return false;

        ListNode slow = head;
        ListNode quick = head.Next;

        while (slow != quick) {
            if (quick == null || quick.Next == null) {
                return false;
            }

            slow = slow.Next;
            quick = quick.Next.Next;
        }

        return true;
    }
}
