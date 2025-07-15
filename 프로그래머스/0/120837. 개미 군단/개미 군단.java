class Solution {
    public int solution(int hp) {
        assureCondition(hp);
        final int MAJOR_ANT_DMG = 5;
        final int SOLDIER_ANT_DMG = 3;
        final int ANT_DMG = 1;


        return hp / MAJOR_ANT_DMG +
                (hp % MAJOR_ANT_DMG) / SOLDIER_ANT_DMG +
                (hp % MAJOR_ANT_DMG) % SOLDIER_ANT_DMG / ANT_DMG;
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