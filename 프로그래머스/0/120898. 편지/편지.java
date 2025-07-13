class Solution {
    public int solution(String message) {
        assureCondition(message.length());
        int fontWidth = 2;
        return message.trim().length() * fontWidth;
    }

    private void assureCondition(int num) {
        int MIN = 1;
        int MAX = 50;
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