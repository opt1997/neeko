package dfs;

// 733. 图像渲染 https://leetcode.cn/problems/flood-fill/

public class LeetCode733 {

    public static void main(String[] args) {
        int[][] image = {
                {0,0,0},
                {0,0,0}
        };
        new LeetCode733().floodFill(image,0,0,0);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, oldColor, color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int oldColor, int color) {
        // 节点要在矩阵中
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        // 像素和旧值相同时，才会进行涂色，否则跳过
        if (image[sr][sc] != oldColor ) {
            return;
        }
        // 已经上色过的节点需要跳过
        if (oldColor == color) {
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr - 1, sc, oldColor, color);
        dfs(image, sr + 1, sc, oldColor, color);
        dfs(image, sr, sc - 1, oldColor, color);
        dfs(image, sr, sc + 1, oldColor, color);
        return;
    }
}
