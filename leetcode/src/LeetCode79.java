// 79. 单词搜索 https://leetcode.cn/problems/word-search/
public class LeetCode79 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 判断从此点开始, 能否找到word[index, len)的子串
    private boolean dfs(char[][] board, int nx, int ny, String word, int index, boolean[][] visited) {
        if (visited[nx][ny]) return false;
        if (board[nx][ny] != word.charAt(index)) {
            return false;
        }

        visited[nx][ny] = true;
        if (index == word.length() - 1) {
            return true;
        }

        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int x = nx + dx[i], y = ny + dy[i];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
            boolean check = dfs(board, x, y, word, index + 1, visited);
            if (check) {
                flag = true;
                break;
            }
        }
        visited[nx][ny] = false;
        return flag;
    }
}
