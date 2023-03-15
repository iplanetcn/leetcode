package solutions;
/**
 * P0007ReverseInteger
 * <p/>
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p/>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p/>
 *
 *
 * Example 1:
 * <p/>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p/>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p/>
 * Input: x = 120
 * Output: 21
 * <p/>
 *
 * Constraints:
 * <p/>
 * -2^31 <= x <= 2^31 - 1
 *
 * @author john
 * @since 2023-02-27
 */
public class P0007ReverseInteger {
    //region Solution First
    public int solutionFirst(int x) {
        try {
            if ((x >= Integer.MAX_VALUE) || (x <= Integer.MIN_VALUE)) {
                return 0;
            }

            String xstr = String.valueOf(x);
            boolean hasNegativeSymbol = xstr.startsWith("-");
            boolean hasPositiveSymbol = xstr.startsWith("+");
            if (hasNegativeSymbol || hasPositiveSymbol) {
                xstr = xstr.substring(1);
            }

            String reverseXStr = reverseString(xstr);
            if (reverseXStr.length() > 0) {
                int value = Integer.parseInt(reverseXStr);
                if (hasNegativeSymbol) {
                    return -value;
                }

                return value;
            }

            return 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String reverseString(String str) {
        char[] chars = str.toCharArray();
        char[] reverseChars = new char[chars.length];
        int j = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseChars[j] = chars[i];
            j++;
        }
        return String.valueOf(reverseChars);
    }
    //endregion

    // ========================================================================================
    public int solutionSecond(int x) {
        int result = 0;

        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result;
    }




}
