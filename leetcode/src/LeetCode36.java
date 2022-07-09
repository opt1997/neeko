// 36. 有效的数独 https://leetcode.cn/problems/valid-sudoku/

public class LeetCode36 {
    public static void main(String[] args) {

    }
    public boolean isValidSudoku(char[][] board) {
        // row中每个数字，都代表了此行的涵盖字符情况. 0000,0000,0110,1010
        short[] row = new short[9];
        short[] col = new short[9];
        short[] area = new short[9];
        int len = 9;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j]=='.') continue;
                int num = 1 << board[i][j]-'0';
                int k = i/3 *3 + j/3;
                if ((row[i] & num)!=0 || (col[j] & num) != 0 || (area[k] & num) != 0) {
                    return false;
                }
                row[i] |= num;
                col[j] |= num;
                area[k] |= num;
            }
        }
        return true;
    }
}
