import entity.ListNode;
import utils.ListNodeHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        return reverse(head, null);
    }

    public ListNode reverse(ListNode head, ListNode newHead) {
        // end point
        if (head.next == null) {
            return new ListNode(head.val, newHead);
        }

        // recurse
        return reverse(head.next, new ListNode(head.val, newHead));

    }



    public static List<Integer> parseIntegerList(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> origin = Arrays.asList(1, 2, 3, 4, 5, 6);
        ListNode head = ListNodeHelper.parseListNode(origin);
        System.out.println(origin);
        ListNode newNode = new ReverseLinkedList().reverseList(head);
        List<Integer> target = parseIntegerList(newNode);
        System.out.println(target);
    }
}
