import java.util.Arrays;

class Solution {
    public double solution(int[] numbers) {
        assureCondition(numbers.length, true, 1, true, 100);
        for (int number : numbers) {
            assureCondition(number);
        }
        
        // 평균 계산
        return Arrays.stream(numbers)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("No numbers provided"));
    }

    private void assureCondition(int num) {
        int MIN = 0;
        int MAX = 1000;
        boolean isMinInclusive = true;
        boolean isMaxInclusive = true;
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