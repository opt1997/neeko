package double_point;

// 344. 反转字符串 https://leetcode.cn/problems/reverse-string/

public class LeetCode344 {
    public void reverseString(char[] s) {
        int l=0,r=s.length-1;
        while (l<r) {
            swap(s,l++,r--);
        }
    }

    private void swap(char[] s, int l, int r) {
        if (l==r) return;
        if (s[l]==s[r]) return;
        s[l] = (char) (s[l] ^ s[r]);
        s[r] = (char) (s[l] ^ s[r]);
        s[l] = (char) (s[l] ^ s[r]);
    }
}
