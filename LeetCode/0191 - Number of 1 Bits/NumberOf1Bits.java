/**
 * @URL: https://leetcode.com/problems/number-of-1-bits/
 */

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        return hammingWeight1(n);
        // return hammingWeight2(n);
        // return hammingWeight3(n);
        // return hammingWeight4(n);
    }

    /**
     * Time : O(log(n))
     * Space: O(1)
     */
    public int hammingWeight1(int n) {
        int weight = 0;
        while (n != 0) {
            ++weight;
            n &= n - 1;
        }
        return weight;
    }

    private static final int[] lookupTable = {
        0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8
    };

    /**
     * For follow up question, we can use lookup table to get the answer.
     * We can decompose the given n in 4 8-bit disjoint words and use lookup to find the number of bits in the word.
     * Time : O(log(n)/4) = O(32/4) = O(8)
     * Space: O(1)
     */
    public int hammingWeight2(int n) {
        int weight = 0;
        while (n != 0) {
            weight += lookupTable[n & 0xFF];
            n >>= 8;
        }
        return weight;
    }

    /**
     * Time : O(log(log(n))) = O(log(32)) = O(5)
     * Space: O(1)
     */
    public int hammingWeight3(int n) {
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >> 16) & 0x0000FFFF);
        return n;
    }

    /** Time : O(log(log(n))) = O(log(32)) = O(5)
     * Space: O(1)
     */
    public int hammingWeight4(int n) {
        return Integer.bitCount(n);
    }
}