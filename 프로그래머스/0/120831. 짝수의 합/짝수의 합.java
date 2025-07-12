class Solution {
    // 등차수열의 합 공식으로,
    // int 자료형이기 때문에 홀수라도 문제가 없다.
    public int solution(int n) {
        assureCondition(n);
        n /= 2;
        return n * (n + 1);
    }

    private void assureCondition(int num) {
        int MIN = 0;
        int MAX = 1000;
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