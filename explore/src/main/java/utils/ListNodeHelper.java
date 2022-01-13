package utils;

import entity.ListNode;

import java.util.List;

/**
 * ListNodeHelper
 *
 * @author john
 * @since 2022-01-13
 */
public class ListNodeHelper {
    public static ListNode parseListNode(List<Integer> integers) {
        ListNode node = null;
        for (int i = integers.size() - 1; i >= 0; i--) {
            node = new ListNode(integers.get(i), node);
        }

        return node;
    }
}
