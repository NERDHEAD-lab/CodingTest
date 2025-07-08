import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.next();
            StringBuilder result = new StringBuilder(input.length() * 2 - 1);
            for (int i = 0; i < input.length(); i++) {
                result.append(input.charAt(i)).append("\n");
            }
            System.out.print(result);
        }
    }

//    public static void solution_else_1() {
//        try (Scanner sc = new Scanner(System.in)) {
//            System.out.println(String.join("\n", sc.next().split("")));
//        }
//    }

//    public static void solution_else_2() {
//        try (Scanner sc = new Scanner(System.in)) {
//            System.out.println(sc.next().replaceAll("", "\n"));
//        }
//    }

//    public static void solution_else_3() {
//        try (Scanner sc = new Scanner(System.in)) {
//            String input = sc.next();
//            StringBuilder result = new StringBuilder(input.length() * 2 - 1);
//            for (int i = 0; i < input.length(); i++) {
//                result.append(input.charAt(i));
//                if (i < input.length() - 1) {
//                    result.append("\n");
//                }
//            }
//            System.out.println(result);
//        }
//    }
}
