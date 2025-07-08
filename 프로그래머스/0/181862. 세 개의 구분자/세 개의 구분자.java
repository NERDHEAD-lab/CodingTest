import java.util.Arrays;

class Solution {
    public String[] solution(String myStr) {
        String[] split = myStr.split("[abc]+");
        if (split.length == 0) {
            return new String[]{"EMPTY"};
        }

        return Arrays.stream(split).filter(s -> !s.isEmpty()).toArray(String[]::new);
    }
}