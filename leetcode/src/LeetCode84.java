import java.util.ArrayDeque;
import java.util.Deque;

// 84. 柱状图中最大的矩形 https://leetcode.cn/problems/largest-rectangle-in-histogram/
public class LeetCode84 {
    public static void main(String[] args) {
        new LeetCode84().largestRectangleArea(new int[]{13,2,2,5,7,89});
    }
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] heightsWithSentries = new int[len+2];
        System.arraycopy(heights, 0, heightsWithSentries, 1, len);
        heights = heightsWithSentries;
        len = heights.length;

        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int high = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                maxArea = Math.max(maxArea, high*width);
            }
            stack.addLast(i);
        }

        return maxArea;
    }
}
