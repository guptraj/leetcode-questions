import java.util.*;
class Solution {
    public void nextLeft(int[] nsol, int[] heights) {
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (st.size() != 0 && heights[st.peek()] > heights[i]) {
                nsol[st.pop()] = i;

            }
            st.push(i);
        }
    }

    public void nextRight(int[] nsol, int[] heights) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (st.size() != 0 && heights[st.peek()] > heights[i]) {
                nsol[st.pop()] = i;

            }
            st.push(i);
        }
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsor = new int[n];
        int[] nsol = new int[n];
        Arrays.fill(nsor, n);
        Arrays.fill(nsol, -1);
        nextLeft(nsol, heights);
        nextRight(nsor, heights);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int w = nsor[i] - nsol[i] - 1;
            max = Math.max(max, heights[i] * w);
        }
        return max;
    }
}