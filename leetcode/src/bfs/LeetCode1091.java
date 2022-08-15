package bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 1091. 二进制矩阵中的最短路径 https://leetcode.cn/problems/shortest-path-in-binary-matrix/
public class LeetCode1091 {
    public static void main(String[] args) {
        new LeetCode1091().shortestPathBinaryMatrix(new int[][]{
                {0, 1},
                {1, 0}
        });
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
        int[][] d = new int[n][n];
        d[0][0] = 1;
        Deque<Point> queue = new ArrayDeque<>();
        queue.addLast(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point cur = queue.removeFirst();
            int nx = cur.x, ny = cur.y;
            for (int i = 0; i < 8; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= n) continue;
                if (grid[x][y] == 1) continue;
                if (d[x][y] != 0) continue;
                d[x][y] = d[nx][ny] + 1;
                if (x == n - 1 && y == n - 1) return d[x][y];
                queue.addLast(new Point(x, y));
            }
        }
        return d[n - 1][n - 1] == 0 ? -1 : d[n - 1][n - 1];
    }


    // 数对
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

