class Solution {
    private final static int AMERICANO = 4500;
    private final static int CAFE_LATTE = 5000;

    public int solution(String[] order) {
        int answer = 0;
        for (String s : order) {
            answer += s.contains("cafelatte") ? CAFE_LATTE : AMERICANO;
        }
        return answer;
    }
}