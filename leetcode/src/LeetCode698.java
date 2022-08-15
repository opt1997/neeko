import java.util.Arrays;

// 叠积木
// 698. 划分为k个相等的子集 https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
public class LeetCode698 {
    public static void main(String[] args) {
        // [2,2,2,2,3,4,5]
        //4
        new LeetCode698().canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4);
    }

    public boolean canPartitionKSubsets(int[] numsCopy, int k) {
        int totalSum = 0;
        for (int num : numsCopy) totalSum += num;
        if (totalSum % k != 0) return false;
        Arrays.sort(numsCopy);
        int[] nums = new int[numsCopy.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[nums.length-i-1] = numsCopy[i];
        }

        boolean[] isUsing = new boolean[nums.length];
        return dfs(nums, 0, 0, 0, k, isUsing, totalSum);
    }

    private boolean dfs(int[] nums, int start, int group, int sum, int k, boolean[] isUsing, int totalSum) {
        if (group == k) return true;
        if (sum > totalSum / k) return false;
        if (sum == totalSum / k) {
            return dfs(nums, 0, group + 1, 0, k, isUsing, totalSum);
        }

        int pre = -1;
        for (int i = start; i < nums.length; i++) {
            if (isUsing[i]) continue;
            if (pre == nums[i]) continue;
            isUsing[i] = true;
            pre = nums[i];
            if (dfs(nums, i+1, group, sum + nums[i], k, isUsing, totalSum)) {
                return true;
            }
            isUsing[i] = false;
        }
        return false;
    }
}

