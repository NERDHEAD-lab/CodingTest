import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String text = sc.next();
            int count = sc.nextInt();
            System.out.print(text.repeat(count));
        }
    }
}