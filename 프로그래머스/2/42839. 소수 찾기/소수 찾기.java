import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        char[] charArray = numbers.toCharArray();
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= charArray.length; i++) {
            permutation(charArray, 0, i, set);
        }

        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private void permutation(char[] charArray, int depth, int r, Set<Integer> set) {
        if (depth == r) {
            try {
                int number = Integer.parseInt(new String(charArray, 0, r));
                set.add(number);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + new String(charArray, 0, r));
//                log.error("Invalid number format: {}", new String(charArray, 0, r));
            }
            return;
        }

        for (int i = depth; i < charArray.length; i++) {
            swap(charArray, depth, i);
            permutation(charArray, depth + 1, r, set);
            swap(charArray, depth, i);
        }
    }

    private boolean isPrime(int num) {
        return num > 1 && !isComposite(num);
    }

    private boolean isComposite(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }


    private void swap(char[] charArray, int depth, int i) {
        char temp = charArray[depth];
        charArray[depth] = charArray[i];
        charArray[i] = temp;
    }
}