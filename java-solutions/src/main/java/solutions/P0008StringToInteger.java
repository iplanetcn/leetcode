package solutions;

import java.util.Vector;

/**
 * P0008StringToInteger
 *
 * @author john
 * @since 2023-03-15
 */
public class P0008StringToInteger {
    public static final char[] prefix = new char[] {'-', '+'};
    public static final char[] digits = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    /**
     * Pass String to Integer
     *
     * @param s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
     */
    public int myAtoi(String s) {
        if (s == null || s.length() == 0 || s.length() > 200) {
            return 0;
        }

        Integer.valueOf("");

        int result = 0;

        Vector<Character> chars = new Vector<>();
        for (char c : s.toCharArray()) {
            chars.add(0, c);
        }
        Vector<Character> validChars = new Vector<>();

        Character symbol = null;
        // TODO implementation the algorithm
        // check input
        // step#1 find valid character array
        // step#2 keep symbol + -
        // step#3 parse character array to integer
        // step#4 check integer


        return result;
    }
}
