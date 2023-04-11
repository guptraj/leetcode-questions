

public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
 this.val = val;
 this.left = left;
 this.right = right;
 }
 }
 
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int tar) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left, tar);
        root.right = removeLeafNodes(root.right, tar);
        if (root.val == tar && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}