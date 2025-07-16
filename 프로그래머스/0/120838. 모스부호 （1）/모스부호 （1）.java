import java.util.Arrays;
import java.util.Map;

class Solution {
    Map<String, Character> morse = Map.ofEntries(
            Map.entry(".-",    'a'), Map.entry("-...", 'b'), Map.entry("-.-.", 'c'),
            Map.entry("-..",   'd'), Map.entry(".",    'e'), Map.entry("..-.", 'f'),
            Map.entry("--.",   'g'), Map.entry("....", 'h'), Map.entry("..",   'i'),
            Map.entry(".---",  'j'), Map.entry("-.-",  'k'), Map.entry(".-..", 'l'),
            Map.entry("--",    'm'), Map.entry("-.",   'n'), Map.entry("---",  'o'),
            Map.entry(".--.",  'p'), Map.entry("--.-", 'q'), Map.entry(".-.",  'r'),
            Map.entry("...",   's'), Map.entry("-",    't'), Map.entry("..-",  'u'),
            Map.entry("...-",  'v'), Map.entry(".--",  'w'), Map.entry("-..-", 'x'),
            Map.entry("-.--",  'y'), Map.entry("--..", 'z')
    );

    public String solution(String letter) {
        assureCondition(letter.length());
        return Arrays.stream(letter.split(" "))
                .map(morse::get)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static void assureCondition(int num) {
        int MIN = 1;
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