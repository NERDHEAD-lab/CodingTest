class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[(int) Math.pow(2, Math.ceil(Math.log(arr.length) / Math.log(2)))];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        return answer;
    }
}