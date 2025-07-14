import java.util.Arrays;

class Solution {
    public String solution(String my_string, int n) {
        assureCondition(my_string.length(), true, 2, true, 5);
        assureCondition(n, true, 2, true, 10);
        
        return Arrays.stream(my_string.split(""))
                .map(s -> s.repeat(n))
                .reduce("", String::concat);
    }

    private static void assureCondition(int num) {
        int MIN = 1;
        int MAX = 10;
        boolean isMinInclusive = true;
        boolean isMaxInclusive = true;
        assureCondition(num, isMinInclusive, MIN, isMaxInclusive, MAX);
    }

    private static void assureCondition(int num, boolean isMinInclusive, int MIN, boolean isMaxInclusive, int MAX) {
        boolean minOk = isMinInclusive ? num >= MIN : num > MIN;
        boolean maxOk = isMaxInclusive ? num <= MAX : num < MAX;

        if (!(minOk && maxOk)) {
            throw new IllegalArgumentException(
                    String.format("Number %d is out of range %d %s %d %s %d",
                            num, MIN, minOk ? "<=" : "<", num, isMaxInclusive ? "<=" : "<", MAX)
            );
        }
    }
}