class Solution {
    public int solution(int n) {
        final boolean isEven = n % 2 == 0;
        return isEven ? evenSquareSum(n) : oddSum(n);
    }

    private int oddSum(int n) {
        int m = (n + 1) / 2;
        return m * m;
    }

    private int evenSquareSum(int n) {
        int m = n / 2;
        return 4 * m * (m + 1) * (2 * m + 1) / 6;
    }
}