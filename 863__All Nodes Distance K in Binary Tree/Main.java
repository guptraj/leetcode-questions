/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public ArrayList<Integer> ans = new ArrayList<>();
    public  ArrayList<TreeNode> nodeToRoot(TreeNode root, int data) {
    if (root == null) return new ArrayList<>();
    if (root.val == data) {
      ArrayList<TreeNode> Ans = new ArrayList<>();
      Ans.add(root);
      return Ans;
    }
    ArrayList<TreeNode> leftAns = nodeToRoot(root.left, data);
    if (leftAns.size() > 0) {
      leftAns.add(root);
      return leftAns;
    }
    ArrayList<TreeNode> rightAns = nodeToRoot(root.right, data);
    if (rightAns.size() > 0) {
      rightAns.add(root);
      return rightAns;
    }
    return new ArrayList<>();
  }

  public void kLevelDown(TreeNode root, int k, TreeNode blocker) {
    if (root == null || root == blocker) return;
    if (k == 0) {
      ans.add(root.val);
      return;
    }
    kLevelDown(root.left, k - 1, blocker);
    kLevelDown(root.right, k - 1, blocker);
  }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> path = nodeToRoot(root, target.val);
        TreeNode blocker = null;
        for (int i = 0; i < path.size(); i++) {
            TreeNode node = path.get(i);
            kLevelDown(node, k - i, blocker);
            blocker = node;
        }
        return ans;
    }
}