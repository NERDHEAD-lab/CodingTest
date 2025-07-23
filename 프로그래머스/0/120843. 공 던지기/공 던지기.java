class Solution {
    public int solution(int[] numbers, int k) {
        assureCondition(numbers.length, false, 2, false, 100);
        assureCondition(k);

        return numbers[(k - 1) * 2 % numbers.length];
    }

    private static void assureCondition(int num) {
        int MIN = 0;
        int MAX = 10000;
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