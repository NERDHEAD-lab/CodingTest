import java.util.stream.IntStream;

class Solution {
    public int solution(int[] array) {
        if (!(array.length%2 == 1)) {
            throw new IllegalArgumentException("Array length must be odd");
        }
        assureCondition(array.length, false, 0, false, 100);
        for (int i : array) {
            assureCondition(i);
        }

        // 정렬 후 중앙 값
        return IntStream.of(array)
                .sorted()
                .skip(array.length / 2)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }

    private void assureCondition(int num) {
        int MIN = -1000;
        int MAX = 1000;
        boolean isMinInclusive = false;
        boolean isMaxInclusive = false;
        assureCondition(num, isMinInclusive, MIN, isMaxInclusive, MAX);
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