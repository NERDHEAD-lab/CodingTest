//import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    /* Sweep Line 알고리즘 */
    public int solution(int[][] lines) {
        List<Point> points = new ArrayList<>();
        for (int[] line : lines) {
            points.add(new Point(line[0], +1)); // 시작점은 +1
            points.add(new Point(line[1], -1)); // 끝점은 -1
        }
        points.sort(Comparator.comparingInt(p -> p.x));

        int overlapCount = 0;
        int answer = 0;
        int prev = points.get(0).x;

        // 두번 이상 겹치는(overlapCount >= 2) 구간의 길이를 answer에 더한다.
        for (Point p : points) {
            if (overlapCount >= 2) {
                answer += p.x - prev;
            }
            overlapCount += p.delta;
            prev = p.x;
        }
        return answer;
    }

    static class Point {
        int x, delta;
        Point(int x, int delta) {
            this.x = x;
            this.delta = delta;
        }
    }

//    @Test
//    public void testSolution() {
//        Solution solution = new Solution();
//        assert solution.solution(new int[][]{{0, 1}, {2, 5}, {3, 9}}) == 2 : "Test case 1 failed";
//        assert solution.solution(new int[][]{{-1, 1}, {1, 3}, {3, 9}}) == 0 : "Test case 2 failed";
//        assert solution.solution(new int[][]{{0, 5}, {3, 9}, {1, 10}}) == 8 : "Test case 3 failed";
//    }
}
