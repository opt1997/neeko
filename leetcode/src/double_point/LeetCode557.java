package double_point;

// 557. 反转字符串中的单词 III https://leetcode.cn/problems/reverse-words-in-a-string-iii/

public class LeetCode557 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = new StringBuilder(split[i]).reverse().toString();
        }
        return String.join(" ", split);
    }
}
