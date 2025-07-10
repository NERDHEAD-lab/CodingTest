class Solution {
    public int[] solution(int brown, int yellow) {
        int yellowSideCount = brown / 2 - 2;
        int[] answer = new int[2];
        for (int i = 1; i <= yellowSideCount / 2; i++) {
            if (i * (yellowSideCount - i) == yellow) {
                answer[0] = yellowSideCount - i + 2;
                answer[1] = i + 2;
                break;
            }
        }
        return answer;
    }
}