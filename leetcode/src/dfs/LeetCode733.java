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

    void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        // 越界
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        // 不满足上色条件则直接返回, 根据题意, 条件有：
        // 1. 该点颜色与oldColor相同; 2. 该点只需要访问一遍. 本题可以利用"当前颜色≠newColor"来判断
        if (image[sr][sc] != oldColor) return; // 不满足处理条件
        if (image[sr][sc] == newColor) return; // 说明已经访问过了，不再访问

        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr + 1, sc, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
        dfs(image, sr, sc + 1, oldColor, newColor);
    }
}
