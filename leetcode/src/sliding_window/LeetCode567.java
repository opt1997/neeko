package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.window;

// 567. 字符串的排列 https://leetcode.cn/problems/permutation-in-string/
public class LeetCode567 {
    public static void main(String[] args) {

        System.out.println(new LeetCode567().checkInclusion("adc", "dcda"));
    }
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i),0)+1);
        }
        for (int p = 0; p < s2.length(); p++) {
            if (p < k) {
                s2Map.put(s2.charAt(p), s2Map.getOrDefault(s2.charAt(p),0)+1);
                if (s1Map.equals(s2Map)) {
                    return true;
                }
                continue;
            }

            // 放
            s2Map.put(s2.charAt(p), s2Map.getOrDefault(s2.charAt(p),0)+1);

            // 取
            if (s2Map.get(s2.charAt(p-k)) == 1) {
                s2Map.remove(s2.charAt(p-k));
            } else {
                s2Map.put(s2.charAt(p-k), s2Map.get(s2.charAt(p-k))-1);
            }


            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }

}
