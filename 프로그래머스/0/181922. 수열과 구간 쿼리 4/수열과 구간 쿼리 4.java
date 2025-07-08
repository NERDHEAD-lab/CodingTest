import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        Arrays.stream(queries)
                .forEach(query -> {
                    final int indexGreaterEqualThan = query[0];
                    final int indexLessEqualThan = query[1] + 1;
                    final int isValueMultiple = query[2];

                    IntStream.range(indexGreaterEqualThan, indexLessEqualThan)
                            .filter(index -> index % isValueMultiple == 0)
                            .forEach(index -> arr[index]++);
                });

        return arr;
    }


}