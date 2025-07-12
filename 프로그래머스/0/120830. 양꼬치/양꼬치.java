class Solution {
    enum Menu {
        LAMB_SKEWERS(12000), DRINKS(2000);

        private final int price;

        Menu(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    /* price of lamb skewers and drinks */
    private static final int EACH_SERVICE = 10;

    public int solution(int lambSkewerCount, int drinkCount) {
        assureCondition(lambSkewerCount);
        assureCondition(drinkCount, true, lambSkewerCount / 10, false, 1000);

        return lambSkewerCount * Menu.LAMB_SKEWERS.getPrice()
                + drinkCount * Menu.DRINKS.getPrice()
                - serviceDrinkCount(lambSkewerCount) * Menu.DRINKS.getPrice();
    }

    private int serviceDrinkCount(int lambSkewerCount) {
        return (lambSkewerCount / EACH_SERVICE);
    }

    private void assureCondition(int num) {
        int MIN = 0;
        int MAX = 1000;
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