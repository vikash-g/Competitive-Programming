/**
 * @URL: https://leetcode.com/problems/longest-string-chain/
 */

public class LongestStringChain {
    /**
     * Time : O(n * L) where L is the maximum length of any given word
     * Space: O(n)
     */
    public int longestStrChain(String[] words) {
        List<Map<String, Integer>> list = new ArrayList<>(16);
        for (int i = 0; i < 16; ++i) {
            list.add(new HashMap<>());
        }

        for (String word : words) {
            list.get(word.length() - 1).put(word, 1);
        }

        int ans = 1;
        for (int i = 1; i < 16; ++i) {
            Map<String, Integer> prev = list.get(i - 1);
            Map<String, Integer> curr = list.get(i);
            if (prev.isEmpty() || curr.isEmpty()) {
                continue;
            }
            for (String word : curr.keySet()) {
                int len = word.length();
                int maxLen = 1;
                for (int l = 0; l < len; ++l) {
                    String w = word.substring(0, l) + word.substring(l + 1);
                    if (prev.containsKey(w)) {
                        maxLen = Math.max(maxLen, prev.get(w) + 1);
                    }
                }
                curr.put(word, maxLen);
                ans = Math.max(ans, maxLen);
            }
        }

        return ans;
    }
}
