import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        assureCondition(numbers.length, true, 2, true, 30);
        for (int number : numbers) {
            assureCondition(number);
        }
        assureCondition(num1, true, 0, false, num2);
        assureCondition(num2, false, num1, false, numbers.length);

        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }

    private static void assureCondition(int num) {
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