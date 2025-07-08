class Solution {
    public int solution(int[] num_list) {
        boolean isEven = true;
        int evenSum = 0;
        int oddSum = 0;

        for (int i : num_list) {
            if (isEven) {
                evenSum += i;
            } else {
                oddSum += i;
            }
            isEven = !isEven;
        }


        return Math.max(evenSum, oddSum);
    }
}