
// 20. 有效的括号 https://leetcode.cn/problems/valid-parentheses/

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode20 {
    public boolean isValid(String s) {
        String left = "([{";
        String right = ")]}";
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (left.indexOf(cur)!=-1) {
                stack.addLast(cur);
            } else {
                if (stack.isEmpty() || left.indexOf(stack.peekLast()) != right.indexOf(cur)) {
                    return false;
                } else {
                    stack.pollLast();
                }
            }
        }
        return stack.isEmpty();
    }
}
