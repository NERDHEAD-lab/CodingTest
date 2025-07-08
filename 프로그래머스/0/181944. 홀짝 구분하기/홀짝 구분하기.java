import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        System.out.println(OddOrEven.of(n));
    }
    
    static class OddOrEven {
        private final int number;

        public OddOrEven(int number) {
            this.number = number;
        }
        
        public static OddOrEven of(int number) {
            return new OddOrEven(number);
        }

        @Override
        public String toString() {
            return String.format("%d is %s", number, number % 2 == 0 ? "even" : "odd");
        }
    }
}