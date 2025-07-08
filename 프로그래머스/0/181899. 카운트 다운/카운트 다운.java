class Solution {
    //count down start(5) to end(1) -> 5 4 3 2 1
    public int[] solution(int start_num, int end_num) {
        int[] result = new int[start_num - end_num + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = start_num--;
        }
        return result;
    }
}