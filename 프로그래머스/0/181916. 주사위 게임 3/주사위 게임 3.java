import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int a, int b, int c, int d) {
        return DiceGame.of(a, b, c, d).getScores();
    }

    static class DiceGame {
        private final Map<Integer, Integer> duplicateStack = new HashMap<>();

        public static DiceGame of(int a, int b, int c, int d) {
            DiceGame diceList = new DiceGame();
            diceList.addAll(a, b, c, d);
            return diceList;
        }
        
        public void addAll(int... dices) {
            for (int dice : dices) {
                add(dice);
            }
        }

        public void add(Integer integer) {
            duplicateStack.put(integer, duplicateStack.getOrDefault(integer, 0) + 1);
        }


        /**
         * 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
         * 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
         * 주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
         * 어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
         * 네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
         */
        public int getScores() {
            DicePattern pattern = DicePattern.of(this);
            List<Integer> sortedStack = duplicateStack.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());


            switch (pattern) {
                case QUADRUPLE:
                    return 1111 * sortedStack.get(0);
                case TRIPLE:
                    return (10 * sortedStack.get(0) + sortedStack.get(1)) * (10 * sortedStack.get(0) + sortedStack.get(1));
                case PAIR:
                    return (sortedStack.get(0) + sortedStack.get(1)) * Math.abs(sortedStack.get(0) - sortedStack.get(1));
                case DOUBLES:
                    return sortedStack.get(1) * sortedStack.get(2);
                case SINGLE:
                    return sortedStack.get(0);
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private enum DicePattern {
        QUADRUPLE, // 4개의 주사위가 모두 같은 숫자
        TRIPLE, // 3개의 주사위가 같은 숫자
        PAIR, // 2개의 주사위가 각각 같은 숫자
        DOUBLES, // 2개의 주사위가 같은 숫자
        SINGLE, // 모든 주사위가 다른 숫자
        ;

        public static DicePattern of(DiceGame dices) {
            int duplicateSize = dices.duplicateStack.size();

            if (duplicateSize == 1) {
                return QUADRUPLE;
            } else if (duplicateSize == 2) {
                return dices.duplicateStack.containsValue(3) ? TRIPLE : PAIR;
            } else if (duplicateSize == 3) {
                return DOUBLES;
            } else if (duplicateSize == 4) {
                return SINGLE;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}