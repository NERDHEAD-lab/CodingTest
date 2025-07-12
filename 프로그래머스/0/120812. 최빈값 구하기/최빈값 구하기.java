import java.util.Map;

class Solution {
    public int solution(int[] array) {
        assureCondition(array.length, false, 0, false, 100);
        for (int i : array) {
            assureCondition(i);
        }

        Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mode = -1;
        int maxFrequency = 0;
        boolean isDuplicate = false;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = num;
                isDuplicate = false;
            } else if (frequency == maxFrequency) {
                isDuplicate = true;
            }
        }

        return isDuplicate ? -1 : mode;
    }

    private void assureCondition(int num) {
        int MIN = 0;
        int MAX = 1000;
        boolean isMinInclusive = true;
        boolean isMaxInclusive = false;
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