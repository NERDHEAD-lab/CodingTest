class Solution {
    enum RockScissorsPaper {
        ROCK(2, 0), // 2 beats 0
        SCISSORS(0, 5), // 0 beats 5
        PAPER(5, 2); // 5 beats 2

        private final int beats;
        private final int losesTo;

        RockScissorsPaper(int beats, int losesTo) {
            this.beats = beats;
            this.losesTo = losesTo;
        }

        public static RockScissorsPaper of(int rsp) {
            for (RockScissorsPaper r : values()) {
                if (r.beats == rsp) {
                    return r;
                }
            }
            throw new IllegalArgumentException("Invalid RSP character: " + rsp);
        }

        public int getLosesTo() {
            return losesTo;
        }
    }

    public String solution(String rsp) {
        assureCondition(rsp.length());
        return rsp.chars()
                .mapToObj(c -> RockScissorsPaper.of(c - '0'))
                .map(rspChar -> String.valueOf(rspChar.getLosesTo()))
                .reduce("", String::concat);
    }

    private static void assureCondition(int num) {
        int MIN = 0;
        int MAX = 100;
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