class Solution {

    public int solution(int num1, int num2) {
        assureCondition(num1);
        assureCondition(num2);
        return num1 - num2;
    }

    private void assureCondition(int num) {
        int MAX = 50000;
        int MIN = -50000;

        if (MIN > num || num > MAX) {
            throw new IllegalArgumentException("Number must be between 0 and 100");
        }
    }
}