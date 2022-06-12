/**
 * @URL: https://leetcode.com/problems/two-sum/
 */
import java.util.*;

public class TwoSum {
    /**
     * Time : O(n)
     * Space: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = {-1, -1};
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int index = map.getOrDefault(target - nums[i], -1);
            if (index != -1) {
                res[0] = index;
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}