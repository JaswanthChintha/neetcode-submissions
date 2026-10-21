

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove elements outside the window
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }

            // Remove smaller elements
            while (!q.isEmpty() &&
                   nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offerLast(i);

            if (i >= k - 1) {
                ans[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return ans;
    }
}