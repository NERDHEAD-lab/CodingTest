class Solution {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        assureCondition(numer1);
        assureCondition(denom1);
        assureCondition(numer2);
        assureCondition(denom2);

        return calculateFraction(numer1, denom1, numer2, denom2);
    }

    private int[] calculateFraction(int numer1, int denom1, int numer2, int denom2) {
        // 분수의 덧셈
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;

        return reduceFraction(numer, denom);
    }

    private int[] reduceFraction(int numer, int denom) {
        // 최대공약수 계산
        int gcd = gcd(numer, denom);
        return new int[]{numer / gcd, denom / gcd};
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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

        if (minOk && maxOk) { return; }

        throw new IllegalArgumentException(
                String.format("Number %d is out of range %d %s %d %s %d",
                        num, MIN, minOk ? "<=" : "<", num, isMaxInclusive ? "<=" : "<", MAX)
        );
    }
}