import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        for (int i = 0; i < arr.length;) {
            if (stk.isEmpty()) {
                stk.add(arr[i++]);
                continue;
            }

            if (stk.get(stk.size() - 1) < arr[i]) {
                stk.add(arr[i++]);
                continue;
            }

            stk.remove(stk.size() - 1);
        }

        return stk.stream().mapToInt(i -> i).toArray();
    }
}