package sliding_window;

import java.util.HashMap;
import java.util.Map;

// 3. 无重复字符的最长子串 https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.get(s.charAt(r)) > 1) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
