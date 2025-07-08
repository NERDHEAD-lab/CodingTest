class Solution {
    public int solution(int a, int b) {
        int digitsA = getDigits(a);
        int digitsB = getDigits(b);
        return Math.max(
                (int) (a * Math.pow(10, digitsB) + b),
                (int) (b * Math.pow(10, digitsA) + a)
        );
    }

    int getDigits(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}