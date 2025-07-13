import java.util.stream.IntStream;

class Solution {
    public int[] solution(int num, int total) {
        assureCondition(num, true, 1, true, 100);
        assureCondition(total, true, 0, true, 1000);

        int center = total / num;
        int start = center - (num / 2);
        
        if (num % 2 == 0) {
            start++;
        }

        return IntStream.rangeClosed(start, start + num - 1)
                .toArray();
    }

    private void assureCondition(int num) {
        int MIN = 1;
        int MAX = 200;
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