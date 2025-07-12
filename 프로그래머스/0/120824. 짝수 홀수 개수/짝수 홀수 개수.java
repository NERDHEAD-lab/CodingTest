class Solution {
    public int[] solution(int[] num_list) {
        assureCondition(num_list.length, true, 1, true, 100);
        for (int i : num_list) {
            assureCondition(i);
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int i : num_list) {
            if (i % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return new int[]{evenCount, oddCount};
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