class Solution {
    public int solution(int num1, int num2) {
        assureMin0Max100(num1);
        assureMin0Max100(num2);
        return num1 % num2;
    }

    private void assureMin0Max100(int num) {
        if (0 < num && num <= 100) { return; }
        throw new IllegalArgumentException("Number must be between 0 and 100");
    }
}