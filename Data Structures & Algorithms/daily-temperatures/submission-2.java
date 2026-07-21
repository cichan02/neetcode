class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures.length <= 1) {
            return result;
        }
        Deque<Integer> stackOfIndices = new ArrayDeque<>();
        stackOfIndices.push(temperatures.length - 1);

        for (int i = result.length - 2; i >= 0; i--) {
            while (!stackOfIndices.isEmpty() && temperatures[stackOfIndices.peek()] <= temperatures[i]) {
                stackOfIndices.pop();
            }

            if (stackOfIndices.isEmpty()) {
                result[i] = 0;
                stackOfIndices.push(i);
                continue;
            }

            result[i] = stackOfIndices.peek() - i;
            stackOfIndices.push(i);
        }
        return result;
    }
}
