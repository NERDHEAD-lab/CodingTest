class Solution {
    public int solution(int[] sides) {
        if (sides.length != 3) {
            throw new IllegalArgumentException("Array must contain exactly 3 elements.");
        }
        for (int side : sides) {
            assureCondition(side);
        }

        return (sides[0] + sides[1] > sides[2] &&
                sides[0] + sides[2] > sides[1] &&
                sides[1] + sides[2] > sides[0]) ? 1 : 2;
    }

    private static void assureCondition(int num) {
        int MIN = 1;
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