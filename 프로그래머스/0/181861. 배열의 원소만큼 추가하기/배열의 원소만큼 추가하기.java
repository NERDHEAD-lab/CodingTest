import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        }
        return list;
    }
}