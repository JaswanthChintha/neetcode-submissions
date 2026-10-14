

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];

            if (curr > 0) {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0
                       && stack.peek() < -curr) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(curr);
                } else if (stack.peek() == -curr) {
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}