class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int length = num_list.length;
        for (int i = 0; i < length; i++) {
            answer[i] = num_list[n % length];
            n++;
        }
        return answer;
    }
}