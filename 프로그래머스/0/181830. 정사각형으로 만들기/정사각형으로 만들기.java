class Solution {
    public int[][] solution(int[][] arr) {
        int height = arr.length;
        int width = arr[0].length;
        if (height == width) { return arr; }

        int length = Math.max(height, width);
        int[][] answer = new int[length][length];

        for (int i = 0; i < height; i++) {
            System.arraycopy(arr[i], 0, answer[i], 0, width);
        }

        return answer;
    }
}