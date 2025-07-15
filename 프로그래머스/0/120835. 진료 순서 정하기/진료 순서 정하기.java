import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] emergency) {
        assureCondition(emergency.length, true, 1, true, 10);
        for (int num : emergency) {
            assureCondition(num);
        }

        return Arrays.stream(emergency)
                .map(k -> (int) IntStream.range(0, emergency.length)
                        .filter(j -> emergency[j] > k)
                        .count() + 1)
                .toArray();
    }

    private static void assureCondition(int num) {
        int MIN = 1;
        int MAX = 100;
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