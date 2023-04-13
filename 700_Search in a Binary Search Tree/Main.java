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
    public TreeNode ans;

    public void searchBSTHelper(TreeNode root, int tar) {
        if (root == null)
            return;
        if (root.val == tar) {
            ans = root;
            return;
        } else if (root.val > tar)
            searchBSTHelper(root.left, tar);
        else if (root.val < tar)
            searchBSTHelper(root.right, tar);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        ans = null;
        searchBSTHelper(root, val);
        return ans;
    }
}