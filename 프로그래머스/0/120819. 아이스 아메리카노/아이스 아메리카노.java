class Solution {
    public int[] solution(int money) {
        assureCondition(money);
        final int ICE_AMERICANO_PRICE = 5500;

        return new int[]{money/ICE_AMERICANO_PRICE, money % ICE_AMERICANO_PRICE};
    }

    private void assureCondition(int num) {
        int MIN = 0;
        int MAX = 1000000;
        boolean isMinInclusive = false;
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