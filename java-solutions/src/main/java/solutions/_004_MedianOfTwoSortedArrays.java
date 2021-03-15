package solutions;

import java.util.Arrays;

public class _004_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        // Traverse both array
        while (i < nums1.length && j < nums2.length) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (nums1[i] < nums2[j]) {
                all[k++] = nums1[i++];
            } else {
                all[k++] = nums2[j++];
            }
        }
        // Store remaining elements of first array
        while (i < nums1.length)
            all[k++] = nums1[i++];

        // Store remaining elements of second array
        while (j < nums2.length)
            all[k++] = nums2[j++];

        double result = 0.0f;
        if (all.length % 2 == 0) {
            // even
            result = (all[all.length / 2 - 1] + all[all.length / 2]) / 2.0f;
        } else {
            // odd
            result = all[all.length / 2];
        }

        System.out.println(Arrays.toString(all));

        return result;
    }
}
