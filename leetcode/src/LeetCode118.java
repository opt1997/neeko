
// 118. 杨辉三角 https://leetcode.cn/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {
    public static void main(String[] args) {
        new LeetCode118().generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    row.add(1);
                } else {
                    row.add(ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
                }
            }
            ans.add(new ArrayList<>(row));
            row.clear();
        }
        return ans;
    }
}
