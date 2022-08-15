package sliding_window;

// 最长递增子序列 https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
public class LeetCode300 {
    public static void main(String[] args) {
        new LeetCode300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = 1;
                continue;
            }
            // 找i之前, 所有a[j]<a[i]的元素中, dp[j]最大的那个
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
