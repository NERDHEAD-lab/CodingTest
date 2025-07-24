import java.util.List;
import java.util.stream.IntStream;

class Solution {
    private final List<String> directions = List.of("left", "right");

    //정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다. 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.
    public int[] solution(int[] numbers, String direction) {
        assureCondition(numbers.length, true, 3, true, 20);
        if (!directions.contains(direction.toLowerCase())) {
            throw new IllegalArgumentException("Direction must be either 'left' or 'right'");
        }

        return switch (direction.toLowerCase()) {
            case "left" -> IntStream.range(0, numbers.length)
                    .map(i -> numbers[(i + 1) % numbers.length])
                    .toArray();
            case "right" -> IntStream.range(0, numbers.length)
                    .map(i -> numbers[(i - 1 + numbers.length) % numbers.length])
                    .toArray();
            default -> throw new IllegalArgumentException("Invalid direction: " + direction);
        };
    }

    private static void assureCondition(int num) {
        int MIN = 0;
        int MAX = 10000;
        boolean isMinInclusive = false;
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