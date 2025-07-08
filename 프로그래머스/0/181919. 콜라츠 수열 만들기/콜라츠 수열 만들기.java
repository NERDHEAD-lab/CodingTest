import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Solution {
    private final Function<Integer, Integer> collatzHandler = (n) -> (n % 2 == 0) ? n / 2 : n * 3 + 1;

    public int[] solution(int n) {
        List<Integer> collatzList = new ArrayList<>();
        collatzList.add(n);
        
        while (n != 1) {
            n = collatzHandler.apply(n);
            collatzList.add(n);
        }
        return collatzList.stream().mapToInt(i -> i).toArray();
    }
}