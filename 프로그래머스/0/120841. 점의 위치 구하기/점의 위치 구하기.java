class Solution {
    enum Quadrant
    {
        Q1(1),
        Q2(2),
        Q3(3),
        Q4(4);

        private final int value;

        Quadrant(int value) {
            this.value = value;
        }

        public static Quadrant fromCoordinates(int x, int y) {
            if (x > 0 && y > 0) {
                return Q1;
            } else if (x < 0 && y > 0) {
                return Q2;
            } else if (x < 0 && y < 0) {
                return Q3;
            } else if (x > 0 && y < 0) {
                return Q4;
            } else {
                throw new IllegalArgumentException("Coordinates must not be on the axes.");
            }
        }

        public int getValue() {
            return value;
        }

    }

    public int solution(int[] dot) {
        if (dot.length != 2) {
            throw new IllegalArgumentException("Input array must contain exactly two elements.");
        }

        for (int i : dot) {
            assureCondition(i);
            if (i == 0) {
                throw new IllegalArgumentException("Coordinates must not be zero.");
            }
        }

        return Quadrant.fromCoordinates(dot[0], dot[1]).getValue();
    }

    private static void assureCondition(int num) {
        int MIN = -500;
        int MAX = 500;
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