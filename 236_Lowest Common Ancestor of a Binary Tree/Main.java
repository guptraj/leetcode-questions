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
    public ArrayList<TreeNode> nodeToRoot(TreeNode node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.val == data) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<TreeNode> leftAns = nodeToRoot(node.left, data);
        if (leftAns.size() > 0) {
            leftAns.add(node);
            return leftAns;
        }
        ArrayList<TreeNode> rightAns = nodeToRoot(node.right, data);
        if (rightAns.size() > 0) {
            rightAns.add(node);
            return rightAns;
        }
        return new ArrayList<>();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathOfP = nodeToRoot(root, p.val);
        ArrayList<TreeNode> pathOfQ = nodeToRoot(root, q.val);

        int i = pathOfP.size() - 1;
        int j = pathOfQ.size() - 1;
        TreeNode LCA = null;
        while (i >= 0 && j >= 0) {
            if (pathOfP.get(i).val != pathOfQ.get(j).val)
                break;
            LCA = pathOfP.get(i);
            i--;
            j--;
        }
        return LCA;

    }
}