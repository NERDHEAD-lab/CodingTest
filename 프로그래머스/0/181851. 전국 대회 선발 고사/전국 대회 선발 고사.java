import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<ComparableRank> ranks = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            ranks.add(new ComparableRank(i, rank[i], attendance[i]));
        }
        Collections.sort(ranks);

        return 10000 * ranks.get(0).index + 100 * ranks.get(1).index + ranks.get(2).index;
    }

    public static class ComparableRank implements Comparable<ComparableRank> {
        final int index;
        final int rank;
        final boolean attendance;

        public ComparableRank(int index, int rank, boolean attendance) {
            this.index = index;
            this.rank = rank;
            this.attendance = attendance;
        }

        @Override
        public int compareTo(ComparableRank o) {
            if (this.attendance && o.attendance) {
                return this.rank - o.rank;
            } else if (this.attendance) {
                return -1;
            } else if (o.attendance) {
                return 1;
            }
            return 0;
        }


        //for debugging
        @Override
        public String toString() {
            return String.format("rank[%d] = {%d, %b}", index, rank, attendance);
        }
    }
}