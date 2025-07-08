import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

class Solution {
    private final Map<Integer, BiFunction<int[], int[], int[]>> slicer_map = Map.of(
            1, this::slice_1,
            2, this::slice_2,
            3, this::slice_3,
            4, this::slice_4
    );

    public int[] solution(int n, int[] slicer, int[] num_list) {
        return slicer_map.get(n).apply(slicer, num_list);
    }

    // num_list[0] ~ slicer[1] 까지의 num_list
    private int[] slice_1(int[] slicer, int[] num_list) {
        int start = 0;
        int end = slicer[1] + 1;
        return Arrays.copyOfRange(num_list, start, end);
    }

    // num_list[slicer[0]] ~ num_list[num_list.length - 1] 까지의 num_list
    private int[] slice_2(int[] slicer, int[] num_list) {
        int start = slicer[0];
        int end = num_list.length;
        return Arrays.copyOfRange(num_list, start, end);
    }

    // num_list[slicer[0]] ~ num_list[slicer[1]] 까지의 num_list
    private int[] slice_3(int[] slicer, int[] num_list) {
        int start = slicer[0];
        int end = slicer[1] + 1;
        return Arrays.copyOfRange(num_list, start, end);
    }

    // num_list[slicer[0]] ~ num_list[slicer[1]] 에서 매번 slicer[2] 만큼 건너뛴 num_list
    private int[] slice_4(int[] slicer, int[] num_list) {
        int start = slicer[0];
        int end = slicer[1] + 1;
        return IntStream.range(start, end)
                .filter(i -> (i - start) % slicer[2] == 0)
                .map(i -> num_list[i])
                .toArray();
    }
}