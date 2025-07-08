import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    private final static int ERROR = -1; 
    
    public int[] solution(int[] arr, int[][] queries) {
        return Arrays.stream(queries)
                .mapToInt(query -> {
                    final int indexGreaterEqualThan = query[0];
                    final int indexLessEqualThan = query[1] + 1;
                    final int valueGreaterThan = query[2];

                    return IntStream.range(indexGreaterEqualThan, indexLessEqualThan).filter(j -> arr[j] > valueGreaterThan).map(j -> arr[j]).min().orElse(ERROR);
                })
                .toArray();
    }
}