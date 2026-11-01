class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Get maximum contribution from left and right
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        // Maximum path passing through current node
        int currentSum = root.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentSum);

        // Return only one branch to parent
        return root.val + Math.max(left, right);
    }
}