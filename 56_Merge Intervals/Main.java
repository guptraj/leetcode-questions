import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] arr = st.pop();
            if (arr[1] >= intervals[i][0]) {
                int em = Math.max(arr[1], intervals[i][1]);
                st.push(new int[] { arr[0], em });
            } else {
                st.push(arr);
                st.push(intervals[i]);
            }
        }
        int[][] ans = new int[st.size()][2];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}