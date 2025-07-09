import java.util.Arrays;
import java.util.regex.Pattern;

class Solution {
    //황희표 패턴
    public int solution(String[] babbling) {
        return (int) Arrays.stream(babbling).filter(Pattern.compile("^(aya|ye|woo|ma)+$").asPredicate()).count();
    }
}