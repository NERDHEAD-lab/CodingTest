import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        assureCondition(balls);
        assureCondition(share);
//        return factorial(balls, share) /factorial(balls - share);
        return factorial(balls, share).divide(factorial(balls - share)).intValue();
    }

    private BigInteger factorial(int n) {
        return factorial(n, 1);
    }

    private BigInteger factorial(int n, int until) {
        if (n <= until) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorial(n - 1, until));
    }


    private static void assureCondition(int num) {
        int MIN = 1;
        int MAX = 30;
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