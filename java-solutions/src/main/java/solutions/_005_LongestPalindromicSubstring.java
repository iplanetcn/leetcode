package solutions;

import java.util.regex.Pattern;

public class _005_LongestPalindromicSubstring {

    //<editor-fold desc="First">
    private boolean isMatchTwo(String s) {
        return s.length() == 2 && s.charAt(0) == s.charAt(1);
    }

    private boolean isMatchThree(String s) {
        return s.length() == 3 && s.charAt(0) == s.charAt(2);
    }

    public String solutionFirst(String s) {
        if (s.length() < 1 || s.length() > 1000) {
            throw new RuntimeException("input `s` out of range");
        }

        if (!Pattern.matches("^[a-zA-Z0-9]*$", s)) {
            throw new RuntimeException("input `s` contains invalid symbols");
        }

        if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2) {
            if (isMatchTwo(s)) {
                return s;
            }
            return s.substring(0, 1);
        }

        if (s.length() == 3) {
            if (isMatchThree(s)) {
                return s;
            }

            if (isMatchTwo(s.substring(0, 2))) {
                return s.substring(0, 2);
            }

            if (isMatchTwo(s.substring(1, 2))) {
                return s.substring(1, 2);
            }
        }

        String result = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && isMatchTwo(s.substring(i, i + 2))) {
                int start = i;
                int end = i + 2;
                while (start >= 0 && end <= s.length()) {
                    if (s.charAt(start) == s.charAt(end - 1)) {
                        String newResult = s.substring(start, end);
                        if (newResult.length() > result.length()) {
                            result = newResult;
                        }
                    } else {
                        break;
                    }

                    start -= 1;
                    end += 1;
                }
            }

            if (i + 2 < s.length() && isMatchThree(s.substring(i, i + 3))) {
                int start = i;
                int end = i + 3;
                while (start >= 0 && end <= s.length()) {
                    if (s.charAt(start) == s.charAt(end - 1)) {
                        String newResult = s.substring(start, end);
                        if (newResult.length() > result.length()) {
                            result = newResult;
                        }
                    } else {
                        break;
                    }

                    start -= 1;
                    end += 1;
                }
            }
        }

        return result;
    }
    //</editor-fold>

    //<editor-fold desc="Second">
    public String solutionSecond(String s) {
        if (s.length() < 1 || s.length() > 1000) {
            throw new RuntimeException("input `s` out of range");
        }

        if (!Pattern.matches("^[a-zA-Z0-9]*$", s)) {
            throw new RuntimeException("input `s` contains invalid symbols");
        }

        String result = s.substring(0, 1);
        String rs = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            int end = i + 2;
            while (end <= s.length()) {
                String sub = s.substring(i, end);
                if (rs.contains(sub) && sub.length() >= result.length()) {
                    if (sub.equals(new StringBuilder(sub).reverse().toString())) {
                        result = sub;
                    }
                } else {
                    break;
                }
                end++;
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold desc="Third">
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String solutionThird(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    //</editor-fold>

}
