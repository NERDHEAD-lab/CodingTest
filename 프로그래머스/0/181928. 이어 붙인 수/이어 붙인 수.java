class Solution {
    // num_list의 값들은 항상 10보다 작음을 보장해야한다.
    public int solution(int[] num_list) {
        int evenSum = 0, oddSum = 0;
        boolean isEven;
        
        for (int num : num_list) {
            isEven = num % 2 == 0;
            if (isEven) {
                evenSum = evenSum * 10 + num;
            } else {
                oddSum = oddSum * 10 + num;
            }
        }
        
        return evenSum + oddSum;
    }
}