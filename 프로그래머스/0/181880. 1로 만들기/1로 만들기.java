class Solution {
    public int solution(int[] num_list) {
        int totalCount = 0;
        for (int value : num_list) {
            totalCount += calc(value);
        }
        return totalCount;
    }

    public int calc(int value) {
        int count = 0;
        while (true) {
            if (value == 1) { return count; }
            value = (value % 2 == 0) ? value / 2 : (value - 1) / 2;
            count++;
        }
    }
}