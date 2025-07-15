class Solution {
    public String solution(int age) {
        assureCondition(age);

        if (age == 0) return "a";

        StringBuilder sb = new StringBuilder();
        int n = age;
        // 가장 높은 자리부터 처리
        int divisor = 1;
        while (n / divisor >= 10) divisor *= 10;

        while (divisor > 0) {
            int digit = n / divisor;
            sb.append((char)('a' + digit));
            n %= divisor;
            divisor /= 10;
        }

        return sb.toString();
    }

    private static void assureCondition(int num) {
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