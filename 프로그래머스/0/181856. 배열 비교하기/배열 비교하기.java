class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int diff = Integer.compare(arr1.length, arr2.length);
        if (diff != 0) {
            return diff;
        }

        for (int i = 0; i < arr1.length; i++) {
            diff += arr1[i] - arr2[i];
        }
        return Integer.compare(diff, 0);
    }
}