import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        assert new Solution().solution(info, edges) == 5;
    }

    public int solution(int[] info, int[][] edges) {
        List<Node<AnimalType>> nodes = createNodes(info, edges);
        List<Integer> visited = new ArrayList<>();
        visited.add(0);

        return findMaxSheep(nodes, visited, 1, 0);
    }

    private int findMaxSheep(List<Node<AnimalType>> nodes, List<Integer> visited, int sheep, int wolves) {
        int maxSheep = sheep;

        for (int i = 0; i < visited.size(); i++) {
            Node<AnimalType> current = nodes.get(visited.get(i));

            for (Node<AnimalType> child : current.children()) {
                int childIndex = child.index();

                if (visited.contains(childIndex)) {
                    continue;
                }

                List<Integer> nextVisited = new ArrayList<>(visited);
                nextVisited.add(childIndex);

                int newSheep = sheep;
                int newWolves = wolves;

                if (child.value() == AnimalType.SHEEP) {
                    newSheep++;
                } else if (child.value() == AnimalType.WOLF) {
                    newWolves++;
                }

                if (newWolves >= newSheep) {
                    continue;
                }

                maxSheep = Math.max(maxSheep, findMaxSheep(nodes, nextVisited, newSheep, newWolves));
            }
        }

        return maxSheep;
    }

    private List<Node<AnimalType>> createNodes(int[] info, int[][] edges) {
        List<Node<AnimalType>> nodes = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            nodes.add(new Node<>(i, AnimalType.of(info[i])));
        }

        for (int[] edge : edges) {
            Node<AnimalType> parent = nodes.get(edge[0]);
            Node<AnimalType> child = nodes.get(edge[1]);
            parent.children().add(child);
        }

        return nodes;
    }

    static class Node<V> {
        private final int index;
        private final List<Node<V>> children = new ArrayList<>();
        private final V value;

        public Node(int index, V value) {
            this.index = index;
            this.value = value;
        }

        public int index() {
            return index;
        }

        public List<Node<V>> children() {
            return children;
        }

        public V value() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    enum AnimalType {
        SHEEP, WOLF;

        public static AnimalType of(int value) {
            return value == 0 ? SHEEP : WOLF;
        }
    }
}
