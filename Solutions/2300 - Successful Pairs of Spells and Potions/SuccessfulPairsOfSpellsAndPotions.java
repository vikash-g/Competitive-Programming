/**
 * @URL: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 */

public class SuccessfulPairsOfSpellsAndPotions {
    /**
     * Time : O(mlog(m) + nlog(m))
     * Space: O(1)
     */
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int n = spells.length;
            int m = potions.length;
            for (int i = 0; i < n; ++i) {
                if (spells[i] >= success) {
                    spells[i] = m;
                } else {
                    spells[i] = m - searchInsert(potions, (success + spells[i] - 1) / spells[i]);
                }
            }
            return spells;
        }

        public int searchInsert(int[] nums, long target) {
            int low = 0;
            int high = nums.length - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return (nums[low] < target) ? (low + 1) : low;
        }
    }
}