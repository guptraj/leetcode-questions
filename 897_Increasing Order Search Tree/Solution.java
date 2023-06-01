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
    ArrayList<TreeNode> arr = new ArrayList<>();
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        arr.add(root);
        inOrder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        inOrder(root);
        int n = arr.size();
        for(int i=0;i<n-1;i++){
            arr.get(i).right = arr.get(i+1);
            arr.get(i).left=null;
        }
        arr.get(n-1).right=null;
        arr.get(n-1).left=null;
        return arr.get(0);
    }
}