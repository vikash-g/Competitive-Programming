/**
 * @URL: https://leetcode.com/problems/sender-with-largest-word-count/
 */

public class SenderWithLargestWordCount {
    /**
     * Time : O(n)
     * Space: O(n)
     */
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        int n = messages.length;
        int maxWordCount = 0;
        String maxWordSender = null;

        for (int i = 0; i < n; ++i) {
            int wordCount = map.getOrDefault(senders[i], 0) + messages[i].split(" ").length;
            map.put(senders[i], wordCount);

            if (wordCount > maxWordCount) {
                maxWordCount = wordCount;
                maxWordSender = senders[i];
            } else if (wordCount == maxWordCount && senders[i].compareTo(maxWordSender) > 0) {
                maxWordSender = senders[i];
            }
        }
        return maxWordSender;
    }
}