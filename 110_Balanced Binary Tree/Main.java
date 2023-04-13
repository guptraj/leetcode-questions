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
    public class pair {
        boolean balanced;
        int height;

        pair() {
        }

        pair(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public pair isBalancedHelper(TreeNode root) {
        if (root == null)
            return new pair(true, -1);
        pair leftAns = isBalancedHelper(root.left);
        if (leftAns.balanced == false)
            return new pair(false, -1);

        pair rightAns = isBalancedHelper(root.right);
        if (rightAns.balanced == false)
            return new pair(false, -1);

        pair myAns = new pair();
        if (Math.abs(leftAns.height - rightAns.height) > 1)
            myAns.balanced = false;
        else
            myAns.balanced = leftAns.balanced && rightAns.balanced;
        myAns.height = Math.max(leftAns.height, rightAns.height) + 1;
        return myAns;
    }

    public boolean isBalanced(TreeNode root) {
        pair ans = isBalancedHelper(root);
        return ans.balanced;
    }
}