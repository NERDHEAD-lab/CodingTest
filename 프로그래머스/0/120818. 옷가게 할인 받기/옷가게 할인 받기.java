class Solution {
    enum DiscountRate {
        RATE_NONE(0, 0),
        RATE_5(100000, 5),
        RATE_10(300000, 10),
        RATE_20(500000, 20),
        ;


        private final int biggerThan;
        private final int rate;

        DiscountRate(int biggerThan, int rate) {
            this.biggerThan = biggerThan;
            this.rate = rate;
        }

        public static DiscountRate of(int price) {
            DiscountRate result = RATE_NONE;

            for (DiscountRate discountRate : DiscountRate.values()) {
                if (price >= discountRate.biggerThan) {
                    result = discountRate;
                }
            }

            return result;
        }

        public int calculate(int price) {
            return price * (100 - rate) / 100;
        }
    }


    public int solution(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException("Price must be a multiple of 10");
        }
        assureCondition(price);
        return DiscountRate.of(price).calculate(price);
    }

    private void assureCondition(int num) {
        int MIN = 10;
        int MAX = 1000000;
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