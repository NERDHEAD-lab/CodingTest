import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < query.length; i++) {
            if ( i % 2 == 0) {
                if (end > query[i]) {
                    end = start + query[i];
                }
            } else {
                start = start + query[i];
            }

//          System.out.printf("%s -> %s\n", Arrays.toString(arr), Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)));
        }

        return Arrays.copyOfRange(arr, start, end + 1);
    }
}