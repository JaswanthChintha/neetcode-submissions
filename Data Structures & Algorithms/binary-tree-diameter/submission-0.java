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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return max;
    }
    public int findHeight(TreeNode root){
        if(root==null) return 0;
        int left=findHeight(root.left);
        int right=findHeight(root.right);
        int diamter=left+right;
        max=Math.max(max,diamter);
        return 1+Math.max(left,right);
    }
}
