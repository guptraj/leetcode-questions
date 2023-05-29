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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  ans = new ArrayList<List<Integer>>(); 
        Queue<TreeNode> st = new LinkedList<>();
        if(root != null){
            st.add(root);
        }
        while(st.size()>0){
            int size = st.size();
            List <Integer> base = new ArrayList<>();
            // while(size-->0){
            //     if(st.peek().left != null) st.add(st.peek().left);
            //     if(st.peek().right != null) st.add(st.peek().right);
            //     base.add(st.remove().val);
            //     size-=1;
            // }
            for(int i=0;i<size;i++){
                TreeNode top = st.remove();
                if(top.left != null) {st.add(top.left);}
                if(top.right != null) {st.add(top.right);}
                base.add(top.val);
            }
            ans.add(base);
        }
        return ans;
    }
}
Console
