import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[][] dots) {
        List<Line> lines = new ArrayList<>();

        List<Position> positions = Arrays.stream(dots).map(dot -> new Position(dot[0], dot[1])).collect(Collectors.toList());
        for (int i = 0; i < positions.size(); i++) {
            for (int j = i + 1; j < positions.size(); j++) {
                try {
                    Line line = new Line(positions.get(i), positions.get(j));
                    lines.add(line);
                } catch (IllegalArgumentException ignored) {
                }
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                Line line1 = lines.get(i);
                Line line2 = lines.get(j);
                if (line1.isAnyEqualPosition(line2)) {
                    continue;
                }
                if (line1.getSlope() == line2.getSlope()) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private static class Position {
        double x, y;

        public Position(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Line {
        Position p1, p2;

        public Line(Position p1, Position p2) {
            this.p1 = p1;
            this.p2 = p2;

            if (isSamePosition()) {
                throw new IllegalArgumentException("Line cannot be drawn with same position");
            }
        }

        private boolean isSamePosition() {
            return p1.x == p2.x && p1.y == p2.y;
        }

        public boolean isAnyEqualPosition(Line line) {
            return p1.equals(line.p1) || p1.equals(line.p2) || p2.equals(line.p1) || p2.equals(line.p2);
        }

        public double getSlope() {
            return (p2.y - p1.y) / (p2.x - p1.x);
        }
    }
}