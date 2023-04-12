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
// Approach 1  tc n2
class Solution {
    public int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int myDia = height(root.left) + height(root.right) + 2;
        return Math.max(ld, Math.max(rd, myDia));
    }
}

//Approach 2  tc n
class Solution {
    static int ans = -(int) 1e9;

    public int diameter(TreeNode root) {
        if (root == null)
            return -1;
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        ans = Math.max(ans, lh + rh + 2);
        int myheight = Math.max(lh, rh) + 1;
        return myheight;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        ans = -(int) 1e9;
        diameter(root);
        return ans;
    }
}