package solutions;

import java.util.Arrays;

/**
 * P0006ZigzagConversion
 * <p/>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p/>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p/>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p/>
 * string convert(string s, int numRows);
 * <p/>
 *
 * Example 1:
 * <p/>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p/>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p/>
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p/>
 *
 * Constraints:
 * <p/>
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 *
 * @author john
 * @since 2023-02-22
 */
public class P0006ZigzagConversion {
    public String solutionFirst(String s, int numRows) {
        if (s == null || s.length() > 1000 || s.length() < 1) {
            return null;
        }

        if (numRows > 1000 || numRows < 1) {
            return null;
        }

        if (numRows == 1) {
            return s;
        }

        String[] ss = new String[numRows];
        Arrays.fill(ss, "");
        int j = 0;
        boolean isAdd = true;
        for (int i = 0; i < s.toCharArray().length; i++) {
            ss[j] += s.charAt(i);
            if (isAdd) {
                j++;
            } else {
                j--;
            }

            if (j == 0) {
                isAdd = true;
            }

            if (j == numRows - 1) {
                isAdd = false;
            }
        }

        String result = "";
        for (String si : ss) {
            if (si != null && si.length() > 0) {
                result = result.concat(si);
            }
        }

        return result;
    }

    public String solutionSecond(String s, int numRows) {
        String result = null;
        // TODO implementation the algorithms
        return result;
    }
}
