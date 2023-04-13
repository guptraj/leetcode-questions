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
    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean lans = isValidBST(root.left);
        if (lans == false)
            return false;
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;
        boolean rans = isValidBST(root.right);
        if (rans == false)
            return false;
        return true;
    }
}