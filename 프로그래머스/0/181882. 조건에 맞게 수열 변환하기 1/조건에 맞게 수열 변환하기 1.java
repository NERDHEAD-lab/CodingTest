class Solution {
    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isEven = arr[i] % 2 == 0;
            boolean isBiggerThan50 = arr[i] >= 50;

            if (isBiggerThan50 ^ isEven) { continue; }
            arr[i] = isBiggerThan50 ? arr[i] / 2 : arr[i] * 2;
        }
        return arr;
    }
}