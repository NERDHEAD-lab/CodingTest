class Solution {
    public int solution(int a, int b) {
        boolean isAOdd = a % 2 == 1;
        boolean isBOdd = b % 2 == 1;
        
        if (isAOdd && isBOdd) {
            return a * a + b * b;
        } else if (!isAOdd && !isBOdd) {
            return Math.abs(a - b);
        } else {
            return 2 * (a + b);
        }
    }
}