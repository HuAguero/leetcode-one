package link.list;

public class ReverseLinkList {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4= new ListNode(4,node5);
        ListNode node3= new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 =  new ListNode(1,node2);
        System.out.println(node1);
       ListNode pre =  recursion(node1);

       System.out.println(pre);
    }

    public static ListNode iterate(ListNode head){
        ListNode prev = null, next;
        ListNode curr = head;
        while (curr != null){
            next = curr.Next;
            curr.Next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode recursion(ListNode head){
        if(head == null || head.Next == null){
            return head;
        }

        ListNode new_head = recursion(head.Next);
        head.Next.Next = head;
        head.Next = null;

        return new_head;
    }
}

