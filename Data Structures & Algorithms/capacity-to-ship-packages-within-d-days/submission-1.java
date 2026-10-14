class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int max = 0;
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }

        for (int capacity = max; capacity <= sum; capacity++) {

            int day = 1;
            int currentWeight = 0;

            for (int i = 0; i < weights.length; i++) {

                if (currentWeight + weights[i] <= capacity) {
                    currentWeight += weights[i];
                } else {
                    day++;
                    currentWeight = weights[i];
                }
            }

            if (day <= days) {
                return capacity;
            }
        }

        return sum;
    }
}