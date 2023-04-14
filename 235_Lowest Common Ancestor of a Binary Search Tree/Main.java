/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                ans = ans.right;
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                ans = ans.left;
                root = root.left;
            } else {
                break;
            }
        }
        return ans;
    }
}