class Solution {
    public int[][] solution(int[] num_list, int n) {
        if (num_list.length % n != 0) {
            throw new IllegalArgumentException("Array length must be divisible by n");
        }
        assureCondition(num_list.length, true, 0, true, 150);
        assureCondition(n, true, 2, true, num_list.length);

        int[][] result = new int[num_list.length / n][n];
        for (int i = 0; i < num_list.length; i++) {
            result[i / n][i % n] = num_list[i];
        }
        return result;
    }

    private static void assureCondition(int num, boolean isMinInclusive, int MIN, boolean isMaxInclusive, int MAX) {
        boolean minOk = isMinInclusive ? num >= MIN : num > MIN;
        boolean maxOk = isMaxInclusive ? num <= MAX : num < MAX;

        if (!(minOk && maxOk)) {
            throw new IllegalArgumentException(
                    String.format("Number %d is out of range %d %s %d %s %d",
                            num, MIN, minOk ? "<=" : "<", num, isMaxInclusive ? "<=" : "<", MAX)
            );
        }
    }
}