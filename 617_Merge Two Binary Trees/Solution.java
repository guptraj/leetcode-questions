/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode p, TreeNode q) {
        if(p!=null && q!= null){
            TreeNode base = new TreeNode();
            base.val = p.val + q.val;
            base.left=mergeTrees(p.left,q.left);
            base.right=mergeTrees(p.right,q.right);
            return base;
        }
        if(p==null && q!=null){
            return q;
        }
        if(p!=null && q==null){
            return p;
        }
        return null;
    }
}