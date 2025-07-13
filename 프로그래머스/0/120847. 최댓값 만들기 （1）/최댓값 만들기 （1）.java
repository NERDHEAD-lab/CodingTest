import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {
        assureCondition(numbers.length, true, 2, true, 100);
        for (int number : numbers) {
            assureCondition(number);
        }

        // 최대값 두개를 곱한다.
        return IntStream.of(numbers)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(2)
                .reduce(1, (a, b) -> a * b);
    }

    private void assureCondition(int num) {
        int MIN = 0;
        int MAX = 10000;
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