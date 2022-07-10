
// 242. 有效的字母异位词 https://leetcode.cn/problems/valid-anagram/

import java.util.Arrays;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        int[] sFrequency = new int[26];
        for (char ch : s.toCharArray()) {
            sFrequency[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (--sFrequency[ch-'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < sFrequency.length; i++) {
            if (sFrequency[i]>0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }
}
