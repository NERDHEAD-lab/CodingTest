class Solution {
    private final int EACH_INDEX = 5;

    public String[] solution(String[] names) {
        int length = names.length;
        String[] answer = new String[length / EACH_INDEX + (length % EACH_INDEX == 0 ? 0 : 1)];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = names[i * EACH_INDEX];
        }
        return answer;
    }
}