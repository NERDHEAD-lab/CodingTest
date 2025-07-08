import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int cursor = 0;
        while (cursor < arr.length) {
            if (stk.isEmpty() || stk.peek() != arr[cursor]) {
                stk.push(arr[cursor]);
            } else {
                stk.pop();
            }
            cursor++;
        }
        if (stk.isEmpty()) {
            return new int[]{-1};
        }

        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}