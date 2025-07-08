import java.util.Map;
import java.util.regex.Pattern;

class Solution {
    private static final Map<String, Pattern> operators = Map.of(
        "+", Pattern.compile(" \\+ "),
        "-", Pattern.compile(" - "),
        "*", Pattern.compile(" \\* ")
    );

    //binomial = "a op b"
    //ex) "1 + 2", "3 - 4", "5 * 6"
    public int solution(String binomial) {
        int result = 0;
        for (String op : operators.keySet()) {
            if (!binomial.contains(String.valueOf(op))) {
                continue;
            }
            //careful regex
            String[] parts = operators.get(op).split(binomial);
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            result = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> result;
            };
        }

        return result;
    }
}