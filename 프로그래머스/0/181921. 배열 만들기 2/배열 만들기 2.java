import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();

        int maxBits = String.valueOf(r).length();
        int maxValue = (1 << maxBits) - 1;

        for (int i = 1; i <= maxValue; i++) {
            int binaryNum = Integer.parseInt(Integer.toBinaryString(i));
            int num = binaryNum * 5;

            if (num >= l && num <= r) {
                answer.add(num);
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
