/**
 * @URL: https://leetcode.com/problems/apply-discount-to-prices/
 */

 // Time : O(n)
 // Space: O(n)
 class Solution {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        String prefix = "";

        for (String w : words) {
            String str = w;
            int len = w.length();

            if (w.charAt(0) == '$' && len > 1) {
                long price = 0;
                boolean found = true;

                for (int i = 1; i < len; ++i) {
                    char ch = w.charAt(i);
                    if (ch == '$' || ch < '0' || ch > '9') {
                        found = false;
                        break;
                    }
                    price = price * 10 + (ch - '0');
                }

                if (found) {
                    str = String.format("$%.02f", (double) price * (100.0 - discount) / 100.0);
                }
            }

            sb.append(prefix).append(str);
            prefix = " ";
        }

        return sb.toString();
    }
}