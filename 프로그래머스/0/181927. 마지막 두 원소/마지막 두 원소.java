class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int[] answer = new int[length + 1];
        System.arraycopy(num_list, 0, answer, 0, length);
        
        if (num_list[length - 1] > num_list[length - 2]) {
            answer[length] = num_list[length - 1] - num_list[length - 2];
        } else {
            answer[length] = num_list[length - 1] * 2;
        }
        return answer;
    }
}