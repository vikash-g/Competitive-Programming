/**
 * @URL: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        // return hasAllCodes1(s, k);
        return hasAllCodes2(s, k);
    }

    /**
     * In this approach, we first generate all the binary values of length k from the given string,
     * then check if all the values are present or not.
     *
     * Time : O(N + 2^k), where N is the length of string s
     * Space: O(2^k)
     */
    public boolean hasAllCodes1(String s, int k) {
        int n = s.length();
        if (n < k) {
            return false;
        }

        int mask = (1 << k) - 1;
        int bitArrSize = ((1 << k) >> 5) + 1;
        int[] bitArr = new int[bitArrSize];

        // Set the remaining bits of last element to 1, so that checking it in the final step will be easy.
        bitArr[bitArrSize - 1] = ~((1 << ((1 << k) & 31)) - 1);

        // Create binary value of length k.
        int value = 0;
        for (int i = 0; i < k; ++i) {
            value = (value << 1) | (s.charAt(i) - '0');
        }
        bitArr[value >> 5] |= 1 << (value & 31);

        // Use sliding window to create next binary values of length k.
        for (int i = k; i < n; ++i) {
            value = (value << 1) & mask | (s.charAt(i) - '0');
            bitArr[value >> 5] |= 1 << (value & 31);
        }

        // Check if all the bit array values are set to 1, otherwise there is some binary value which is missing.
        for (int i = 0; i < bitArrSize; ++i) {
            if (bitArr[i] != 0xFFFFFFFF) {
                return false;
            }
        }

        return true;
    }

    /**
     * In this approach we keep checking the required number of binary string as we keep generating the binary strings of length k.
     *
     * Time : O(N)
     * Space: O(2^k)
     */
    public boolean hasAllCodes2(String s, int k) {
        int n = s.length();
        if (n < k) {
            return false;
        }

        int mask = (1 << k) - 1;
        int[] bitArr = new int[((1 << k) >> 5) + 1];

        // Create binary value of length k.
        int value = 0;
        for (int i = 0; i < k; ++i) {
            value = (value << 1) | (s.charAt(i) - '0');
        }
        bitArr[value >> 5] |= 1 << (value & 31);
        int required = (1 << k) - 1;

        // Use sliding window to create next binary values of length k.
        for (int i = k; i < n; ++i) {
            value = (value << 1) & mask | (s.charAt(i) - '0');

            // If current value is newly found, adjust the required value and if there is no more required number return true.
            if ((bitArr[value >> 5] & (1 << (value & 31))) == 0) {
                bitArr[value >> 5] |= 1 << (value & 31);
                if (--required == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
