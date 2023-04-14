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
    public int max(TreeNode root) {
        TreeNode ans = root;
        while (ans.right != null) {
            ans = ans.right;
        }
        return ans.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            }
            int lmax = max(root.left);
            root.val = lmax;
            root.left = deleteNode(root.left, lmax);
        }
        return root;
    }
}