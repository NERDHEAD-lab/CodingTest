import java.util.stream.IntStream;

class Solution {
    public String solution(String my_string, int eachLine, int position) {
        char[] charArray = my_string.toCharArray();
        return IntStream.range(0, charArray.length / eachLine)
                .map(i -> i * eachLine + position - 1)
                .collect(StringBuilder::new, (sb, i) -> sb.append(charArray[i]), StringBuilder::append)
                .toString();
    }
}