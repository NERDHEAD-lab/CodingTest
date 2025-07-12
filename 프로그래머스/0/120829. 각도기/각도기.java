class Solution {
    public enum AngleType {
        // 예각
        ACUTE(1),
        // 직각
        RIGHT(2),
        // 둔각
        OBTUSE(3),
        // 평각
        STRAIGHT(4);
        
        private final int value;
        
        AngleType(int value) {
            this.value = value;
        }
        
        public static AngleType fromAngle(int angle) {
            if (angle < 0 || angle > 180) {
                throw new IllegalArgumentException("Angle must be between 0 and 180 degrees.");
            }
            if (angle < 90) {
                return ACUTE;
            } else if (angle == 90) {
                return RIGHT;
            } else if (angle < 180) {
                return OBTUSE;
            } else {
                return STRAIGHT;
            }
        }
        
        public int getValue() {
            return value;
        }
    }

    public int solution(int angle) {
        assureCondition(angle);
        return AngleType.fromAngle(angle).getValue();
    }

    private void assureCondition(int num) {
        int MIN = 0;
        int MAX = 180;
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