class Solution {
    public int solution(int a, int b) {
        return (int) Math.max(
                a * Math.pow(10, (int) (Math.log10(b) + 1)) + b,
                2 * a * b
        );
    }
}