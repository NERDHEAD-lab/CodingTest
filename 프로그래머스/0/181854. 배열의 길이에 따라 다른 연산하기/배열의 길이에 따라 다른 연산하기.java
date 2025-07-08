class Solution {
    public int[] solution(int[] arr, int n) {
        boolean isEvenLength = arr.length % 2 == 0;

        boolean isEvenIndex = true;
        for (int i = 0; i < arr.length; i++) {
            //만약 배열의 길이가 짝수면 arr의 모든 홀수 인덱스에 n을 더한다.
            if (isEvenLength ^ isEvenIndex) {
                arr[i] += n;
            }
            isEvenIndex = !isEvenIndex;
        }

        return arr;
    }
}