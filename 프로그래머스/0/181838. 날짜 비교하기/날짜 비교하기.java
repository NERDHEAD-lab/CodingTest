class Solution {
    // [YYYY, MM, DD]
    public int solution(int[] date1, int[] date2) {
        for (int i = 0; i < date1.length; i++) {
            if (date1[i] < date2[i]) { return 1; }
            if (date1[i] > date2[i]) { break; }
        }
        return 0;
    }
}