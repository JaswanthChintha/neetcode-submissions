class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        boolean changed = true;

        while (changed) {

            changed = false;

            for (int i = 0; i < n; i++) {

                // Already merged
                if (intervals[i][0] == -1)
                    continue;

                for (int j = i + 1; j < n; j++) {

                    if (intervals[j][0] == -1)
                        continue;

                    // Check if intervals overlap
                    if (intervals[i][1] >= intervals[j][0] &&
                        intervals[j][1] >= intervals[i][0]) {

                        // Merge
                        intervals[i][0] =
                            Math.min(intervals[i][0], intervals[j][0]);

                        intervals[i][1] =
                            Math.max(intervals[i][1], intervals[j][1]);

                        // Mark j as removed
                        intervals[j][0] = -1;
                        intervals[j][1] = -1;

                        changed = true;
                    }
                }
            }
        }

        // Count remaining intervals
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] != -1) {
                count++;
            }
        }

        // Create answer
        int[][] result = new int[count][2];

        int k = 0;

        for (int i = 0; i < n; i++) {

            if (intervals[i][0] != -1) {

                result[k][0] = intervals[i][0];
                result[k][1] = intervals[i][1];

                k++;
            }
        }

        return result;
    }
}