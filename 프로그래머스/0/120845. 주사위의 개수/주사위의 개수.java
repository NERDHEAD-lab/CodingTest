class Solution {
    public int solution(int[] box, int n) {
        if (box == null || box.length != 3) {
            throw new IllegalArgumentException("Box must have exactly 3 dimensions.");
        }
        for (int dimension : box) {
            assureCondition(dimension);
            if (n <= dimension) continue;

//            throw new IllegalArgumentException("n must be less than or equal to each dimension of the box.");
        }
        assureCondition(n, true, 1, true, 50);

        int width = box[0];
        int height = box[1];
        int depth = box[2];

        return (width / n) * (height / n) * (depth / n);
    }

    private static void assureCondition(int num) {
        int MIN = 1;
        int MAX = 100;
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