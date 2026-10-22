

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);

        int fleets = 0;
        double time = 0;

        // Start from the car closest to target
        for (int i = n - 1; i >= 0; i--) {
            double currentTime =
                (double) (target - cars[i][0]) / cars[i][1];

            if (currentTime > time) {
                fleets++;
                time = currentTime;
            }
        }

        return fleets;
    }
}