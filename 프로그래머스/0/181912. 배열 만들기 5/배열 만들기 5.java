import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String[] intStrs, int greaterThanCondition, int index, int length) {
        List<Integer> answer = new ArrayList<>();
        for (String intStr : intStrs) {
            int num = Integer.parseInt(intStr.substring(index, index + length));
            if (num > greaterThanCondition) {
                answer.add(num);
            }
        }

        return answer;
    }
}