class Solution {
    public int[] solution(int[] arr, int k) {
        boolean isEven = k % 2 == 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = isEven ? arr[i] + k : arr[i] * k;
        }
        return arr;
    }
}