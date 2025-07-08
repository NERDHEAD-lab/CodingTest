import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (String str : strArr) {
            int value = map.getOrDefault(str.length(), 0) + 1;
            map.put(str.length(), value);
            max = Math.max(max, value);
        }
        
        return max;
    }       
}