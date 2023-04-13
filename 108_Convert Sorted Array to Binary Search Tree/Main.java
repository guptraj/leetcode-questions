/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode builtBST(int[] arr, int i, int j) {
        if (i > j)
            return null;
        int mid = (i + j) / 2;
        TreeNode ans = new TreeNode();
        ans.val = arr[mid];
        ans.left = builtBST(arr, i, mid - 1);
        ans.right = builtBST(arr, mid + 1, j);
        return ans;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return builtBST(nums, 0, nums.length - 1);
    }
}