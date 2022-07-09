
// 566. 重塑矩阵 https://leetcode.cn/problems/reshape-the-matrix/

public class LeetCode566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ans = new int[r][c];
        int m = mat.length;
        int n = m>0?mat[0].length:0;
        if (m*n!=r*c) {
            return mat;
        }
        int col = 0;
        int row = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = mat[row][col];
                col++;
                if (col >= n) {
                    col = 0;
                    row++;
                }
            }
        }
        return ans;
    }
}
