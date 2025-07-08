class Solution {
    public int[] solution(int n, int k) {
//        return IntStream.range(1, n/k + 1).map(i -> i * k).toArray();
        int[] result = new int[n/k];
        for (int i = 0; i < result.length;) { result[i++] = k * i; }
        return result;
    }
}