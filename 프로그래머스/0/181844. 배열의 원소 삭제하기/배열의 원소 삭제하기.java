import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        return IntStream.of(arr).filter(value -> !contains(delete_list, value)).toArray();
    }
    
    private boolean contains(int[] delete_list, int value) {
        for (int i : delete_list) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}