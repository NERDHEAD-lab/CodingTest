class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] switchIndex : queries) {
            int temp = arr[switchIndex[0]];
            arr[switchIndex[0]] = arr[switchIndex[1]];
            arr[switchIndex[1]] = temp;
        }
        
        return arr;
    }
}