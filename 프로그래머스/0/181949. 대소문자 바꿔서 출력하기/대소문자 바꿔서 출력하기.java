import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(
                a.chars()
                        .map(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        );
    }

//    public static void solution_else_1(String a) {
//        StringBuilder sb = new StringBuilder();
//        for (char c : a.toCharArray()) {
//            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
//        }
//        System.out.println(sb);
//    }
}