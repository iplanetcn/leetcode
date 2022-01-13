package solutions

class _004_MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val arr = IntArray(nums1.size + nums2.size)
        var i = 0
        var j = 0
        var k = 0

        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++]
            } else {
                arr[k++] = nums2[j++]
            }
        }

        while (i < nums1.size) {
            arr[k++] = nums1[i++]
        }

        while (j < nums2.size) {
            arr[k++] = nums2[j++]
        }

        return when {
            arr.size % 2 == 0 -> {
                (arr[arr.size / 2 - 1] + arr[arr.size / 2]) / 2.0
            }
            else -> {
                arr[arr.size / 2] * 1.0
            }
        }
    }
}