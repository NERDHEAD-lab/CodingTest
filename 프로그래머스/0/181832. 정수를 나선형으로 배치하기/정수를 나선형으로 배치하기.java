class Solution {
    //황금 장방향
    //비율 1:1.618의 장방형 속에서, 정확한 소용돌이를 만들어 회전을 시키면, [손톱 탄]은 이론상, 무한의 회전이 된다.
    //이것이 [황금의 회전], 그리고, 그것은 죠니의 스탠드 능력과 합쳐져 [이동하는 구멍]이 되어 적을 추적한다.
    public int[][] solution(int n) {
        Direction direction = Direction.RIGHT;
        int[][] answer = new int[n][n];
        int x = 0, y = 0;
        int max = n * n;
        for (int i = 1; i <= max; i++) {
            answer[y][x] = i;

            int nextX = direction.getX(x);
            int nextY = direction.getY(y);
            if (!direction.canMove(answer, nextX, nextY)) {
                direction = direction.next();
                nextX = direction.getX(x);
                nextY = direction.getY(y);
            }

            x = nextX;
            y = nextY;
        }

        return answer;
    }

    enum Direction {
        RIGHT, DOWN, LEFT, UP;

        public int getX(int x) {
            switch (this) {
                case RIGHT: return x + 1;
                case LEFT: return x - 1;
                default: return x;
            }
        }

        public int getY(int y) {
            switch (this) {
                case DOWN: return y + 1;
                case UP: return y - 1;
                default: return y;
            }
        }

        public boolean canMove(int[][] arr, int x, int y) {
            return x >= 0 && x < arr[0].length && y >= 0 && y < arr.length && arr[y][x] == 0;
        }

        public Direction next() {
            return values()[(ordinal() + 1) % values().length];
        }
    }
}