package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p/>
 * Example:
 * <p/>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p/>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
class P0001TwoSum {
    /**
     * Complexity Analysis
     * <p/>
     * Time complexity : O(n^2).
     * For each element, we try to find its complement by looping through the rest of array which takes O(n) time. Therefore, the time complexity is O(n^2).
     * <p/>
     * Space complexity : O(1).
     */
    int[] solutionFirst(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        throw new RuntimeException("No two sum solution");
    }

    /**
     * Complexity Analysis:
     * <p/>
     * Time complexity : O(n). We traverse the list containing nn elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n).
     * <p/>
     * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly nn elements.
     */
    int[] solutionSecond(int[] nums, int target) {
        // value, key
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }

        throw new RuntimeException("No two sum solution");
    }

    /**
     * Complexity Analysis:
     * <p/>
     * Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.
     * <p/>
     * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
     */
    int[] solutionThird(int[] nums, int target) {
        // value, key
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        throw new RuntimeException("No two sum solution");
    }
}
