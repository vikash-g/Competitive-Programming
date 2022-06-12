/**
 * @URL: https://leetcode.com/problems/strong-password-checker-ii/
 */

public class StrongPasswordCheckerII {
    /**
     * Time : O(n)
     * Space: O(1)
     */
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        String special = "!@#$%^&*()-+";
        int flag = 0;

        char prev = '\0';
        for (char ch : password.toCharArray()) {
            if (ch == prev) {
                return false;
            }
            prev = ch;
            if ('a' <= ch && ch <= 'z') {
                flag |= 1;
            } else if ('A' <= ch && ch <= 'Z') {
                flag |= 2;
            } else if ('0' <= ch && ch <= '9') {
                flag |= 4;
            } else if (special.indexOf(ch) != -1) {
                flag |= 8;
            }
        }
        return flag == 15;
    }
}