import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
        assureCondition(num_list.length, true, 1, true, 1000);
        for (int i : num_list) {
            assureCondition(i);
        }

        return IntStream.range(0, num_list.length)
                .map(i -> num_list[num_list.length - 1 - i])
                .toArray();
    }

private void assureCondition(int num) {
    int MIN = 0;
    int MAX = 1000;
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