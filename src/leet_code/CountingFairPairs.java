package leet_code;

import java.util.Arrays;

public class CountingFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = 0;

        for (int i = 0; i < n - 1; i++) {
            int currentNum = nums[i];
            int lowerBoundIndex = lowerBinarySearch(nums, i + 1, n, lower - currentNum);
            int upperBoundIndex = upperBinarySearch(nums, i + 1, n, upper - currentNum);
            res += upperBoundIndex - lowerBoundIndex;
        }
        return res;
    }

    private int lowerBinarySearch(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int upperBinarySearch(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}

