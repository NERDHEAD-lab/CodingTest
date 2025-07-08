import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String my_string) {
        List<String> answer = new ArrayList<>();
        int start = 0, end;
        while ((end = my_string.indexOf(' ', start)) != -1) {
            if (end > start) {
                answer.add(my_string.substring(start, end));
            }
            start = end + 1;
        }
        if (start < my_string.length()) {
            answer.add(my_string.substring(start));
        }
        return answer.toArray(new String[0]);
    }
}
