package solutions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static solutions._002_AddTwoNumbers.Utils.*;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
class _002_AddTwoNumbers {

    /**
     * the recommended solution
     */
    ListNode solutionFirst(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        do {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            // 1. Add together
            int sum = l1val + l2val + carry;
            // 2. Molding as the carry
            carry = sum / 10;
            // 3. Find the remainder
            int val = sum % 10;
            // 4. Construct node and put it to the next end node
            ListNode nln = new ListNode(val);
            if (result == null) {
                result = nln;
            } else {
                putNextEnd(result, val);
            }

            // 5. Judge the objects, if it is not null, then point to the next, or do nothing.
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);

        if (carry > 0) {
            putNextEnd(result, carry);
        }

        return result;
    }

    /**
     * a lucky solution (PS: it just passes the leetcode.com testing, not recommend for study algorithms)
     */
    ListNode solutionSecond(ListNode l1, ListNode l2) {
        // using BigDecimal to avoid numerical out of bounds
        BigDecimal num1 = listNodeToNum(l1);
        BigDecimal num2 = listNodeToNum(l2);
        BigDecimal sum = num1.add(num2);
        return numToListNode(sum);
    }

    /**
     * --- official solution --- (similar to {@link #solutionFirst(ListNode, ListNode)})
     */
    ListNode solutionThird(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    /**
     * convert the ListNode Object to a BigDecimal number
     */
    private BigDecimal listNodeToNum(ListNode ln) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = ln;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }

        return new BigDecimal(sb.toString());
    }

    /**
     * convert the BigDecimal number to a ListNode Object
     */
    private ListNode numToListNode(BigDecimal num) {
        char[] arr = String.valueOf(num).toCharArray();
        ArrayList<Integer> list = new ArrayList<>();

        for (char c : arr) {
            list.add(Integer.valueOf(String.valueOf(c)));
        }

        Collections.reverse(list);

        return toListNode(list, null);
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        /**
         * help testing data display
         */

        @Override
        public String toString() {
            return Arrays.toString(toCommonList(this, new ArrayList<>()).toArray());
        }
    }


    /**
     * tools
     */
    static class Utils {
        /**
         * Add values ​​to the end of the next node
         */
        static void putNextEnd(ListNode origin, int val) {
            ListNode temp = origin;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }

        /**
         * Recursion function: Convert a normal array to a linked list
         */
        static ListNode toListNode(ArrayList<Integer> list, ListNode ln) {
            if (list.size() == 0) {
                return ln;
            }

            if (ln == null) {
                ln = new ListNode(list.remove(0));
            } else {
                putNextEnd(ln, list.remove(0));
            }

            return toListNode(list, ln);
        }

        /**
         * Recursion function: Convert a linked list to a normal array
         */
        static List<Integer> toCommonList(ListNode ln, ArrayList<Integer> list) {
            if (ln == null) {
                return list;
            }

            list.add(ln.val);
            ln = ln.next;
            return toCommonList(ln, list);
        }
    }

}