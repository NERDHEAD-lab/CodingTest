import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        for (int j : arr) {
            if (!set.add(j)) { continue; }
            answer[idx++] = j;
            if (idx == k) { break; }
        }

        for(int i = idx; i < k; i++) {
            answer[i] = -1;
        }


        return answer;
    }
}