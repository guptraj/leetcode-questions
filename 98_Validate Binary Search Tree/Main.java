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
// approach 1 by inorder transversal 
class Solution {
    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean lans = isValidBST(root.left);
        if (lans == false)
            return false;
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;
        boolean rans = isValidBST(root.right);
        if (rans == false)
            return false;
        return true;
    }
}

// Approach 2 by pair concept
class Solution {
    class Pair{
        boolean isBST;
        long max;
        long min;
        Pair(){}
        Pair(boolean isBST,long max,long min){
            this.isBST=isBST;
            this.max=max;
            this.min=min;
        }
    }
    public Pair helper(TreeNode root){
       if (root==null) return new  Pair(true,Long.MIN_VALUE,Long.MAX_VALUE);
        Pair lans = helper(root.left);
        if(!lans.isBST) return new Pair(false,0,0);
        Pair rans = helper(root.right);
        if(!rans.isBST) return new Pair(false,0,0);
        Pair ans = new Pair();
        ans.isBST = lans.isBST && rans.isBST && lans.max<root.val && root.val<rans.min;
        ans.max=Math.max(root.val,rans.max);
        ans.min = Math.min(root.val,lans.min);
        return ans;

    }
    public boolean isValidBST(TreeNode root) {
       Pair ans = helper(root);
       return ans.isBST;

    }
}