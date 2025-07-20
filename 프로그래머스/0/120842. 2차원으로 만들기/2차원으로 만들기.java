import java.util.stream.IntStream;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        if (num_list.length % n != 0) {
            throw new IllegalArgumentException("Array length must be divisible by n");
        }
        assureCondition(num_list.length, true, 0, true, 150);
        assureCondition(n, true, 2, true, num_list.length);

        return IntStream.range(0, num_list.length / n)
                .mapToObj(i -> {
                    int start = i * n;
                    int end = start + n;
                    return java.util.Arrays.stream(num_list, start, end).toArray();
                })
                .toArray(int[][]::new);
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