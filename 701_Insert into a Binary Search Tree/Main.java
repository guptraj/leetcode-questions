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
    public void insertIntoBSTHelper(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                TreeNode ans = new TreeNode();
                ans.val = val;
                root.right = ans;
                return;
            }
            insertIntoBSTHelper(root.right, val);
        } else {
            if (root.left == null) {
                TreeNode ans = new TreeNode();
                ans.val = val;
                root.left = ans;
                return;
            }
            insertIntoBSTHelper(root.left, val);

        }

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode ans = new TreeNode();
            ans.val = val;
            return ans;
        }
        insertIntoBSTHelper(root, val);
        return root;
    }
}