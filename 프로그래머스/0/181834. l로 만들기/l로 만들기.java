class Solution {
    public String solution(String myString) {
        return myString.chars()
                .map(i -> Integer.max(i, 'l'))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}