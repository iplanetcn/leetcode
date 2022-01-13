import entity.ListNode;
import utils.ListNodeHelper;

import java.util.Arrays;

/**
 * MergeTwoLists
 *
 * @author john
 * @since 2022-01-13
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeHelper.parseListNode(Arrays.asList(1, 2, 3, 4));
        ListNode l2 = ListNodeHelper.parseListNode(Arrays.asList(1, 2, 3, 4));
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }
}