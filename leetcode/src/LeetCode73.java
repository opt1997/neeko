import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 73. 矩阵置零 https://leetcode.cn/problems/set-matrix-zeroes/
public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> row = new HashSet();
        Set<Integer> col = new HashSet();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (row.contains(i)) {
                Arrays.fill(matrix[i],0);
                continue;
            }
            for (int j = 0; j < n; j++) {
                if(col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
