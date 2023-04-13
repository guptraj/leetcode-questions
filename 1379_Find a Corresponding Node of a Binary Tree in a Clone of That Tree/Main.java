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
    public TreeNode ans = null;

    public void getTargetCopyhelper(TreeNode cloned, int tar) {
        if (cloned == null)
            return;
        if (tar == cloned.val) {
            ans = cloned;
        }
        getTargetCopyhelper(cloned.left, tar);
        getTargetCopyhelper(cloned.right, tar);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        getTargetCopyhelper(cloned, target.val);
        return ans;
    }
}