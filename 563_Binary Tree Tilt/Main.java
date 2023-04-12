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
    static int tilt = 0;

    public int findTiltHelper(TreeNode root) {
        if (root == null)
            return 0;
        int ls = findTiltHelper(root.left);
        int rs = findTiltHelper(root.right);
        tilt += Math.abs(ls - rs);
        return ls + rs + root.val;
    }

    public int findTilt(TreeNode root) {
        tilt = 0;
        findTiltHelper(root);
        return tilt;
    }
}