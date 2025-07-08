class Solution {
    public String[] solution(String[] picture, int times) {
        String[] answer = new String[picture.length * times];
        for (int i = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < picture[i].length(); j++) {
                sb.append(String.valueOf(picture[i].charAt(j)).repeat(Math.max(0, times)));
            }
            for (int j = 0; j < times; j++) {
                answer[i * times + j] = sb.toString();
            }
        }
        return answer;
    }
}