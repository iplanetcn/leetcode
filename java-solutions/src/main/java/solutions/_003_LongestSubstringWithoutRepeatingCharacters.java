package solutions;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
class _003_LongestSubstringWithoutRepeatingCharacters {

    int first(String s) {
        if (s == null) {
            return 0;
        }

        List<Character> temp = new ArrayList<>();
        int longest = 0;

        for (char c : s.toCharArray()) {
            if (temp.contains(c)) {
                int from = temp.indexOf(c) + 1;
                int end = temp.size();
                temp = temp.subList(from, end);
            }

            temp.add(c);

            longest = temp.size() > longest ? temp.size() : longest;
        }

        return longest;
    }


    int second(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    /**
     * check string's characters are all unique
     *
     * if it is, return true, or return false
     */
    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * optimized
     */
    int third(String s) {
        // 1. check null
        if (s == null) {
            return 0;
        }

        // 2. collect characters appeared (use Set to ensure it unique, which won't count duplicated character)
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }


        // 3. get unique character size, find target from longest to shortest
        final int N = set.size();
        for (int i = N; i >= 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (allUnique(s, j, j + i)) {
                    return i;
                }
            }
        }

        // 4. if find none, then return zero
        return 0;
    }

    /**
     *
     */
    int fourth(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * ?
     */
    int fifth(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * ?
     */
    int sixth(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


}
