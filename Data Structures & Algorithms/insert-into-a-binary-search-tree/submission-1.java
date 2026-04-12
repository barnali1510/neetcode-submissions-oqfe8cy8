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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode temp = new TreeNode(val);
        TreeNode parent = null;
        TreeNode current = root;

        while(current != null) {
            parent = current;

            if(current.val > val) {
                current = current.left;
            } else if(current.val < val) {
                current = current.right;
            } else {
                return root;
            }
        }

        if(parent == null) {
            return temp;
        } else if(parent.val > val) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }

        return root;
        
    }
}