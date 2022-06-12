/**
 * @URL: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] nums, int target) {
        // return twoSum1(nums, target);
        return twoSum2(nums, target);
    }

    /**
     * In this approach we are using binary search to find the pairs.
     * For any index i, check if target - nums[i] is present in [i + 1, n - 1] range.
     *
     * Time : O(nlog(n))
     * Space: O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int idx = binarySearch(nums, i + 1, target - nums[i]);
            if (idx != -1) {
                return new int[]{i + 1, idx + 1};
            }
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int from, int target) {
        int to = nums.length - 1;
        while (from <= to) {
            int mid = (from + to) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        }
        return -1;
    }

    /**
     * This approach uses two pointer technique to find the pairs.
     *
     * Time : O(n)
     * Space: O(1)
     */
    public int[] twoSum2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }
        return new int[]{-1, -1};
    }
 }