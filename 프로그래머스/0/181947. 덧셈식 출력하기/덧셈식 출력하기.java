import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.printf("%d + %d = %d%n", a, b, a + b);
        }
    }
}