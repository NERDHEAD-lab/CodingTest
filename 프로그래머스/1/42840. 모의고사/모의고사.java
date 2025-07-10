import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("1", 1, 2, 3, 4, 5));
        students.add(new Student("2", 2, 1, 2, 3, 2, 4, 2, 5));
        students.add(new Student("3", 3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        int maxScore = 0;
        for (Student student : students) {
            student.evaluateAnswers(answers);
            maxScore = Math.max(maxScore, student.getScore());
        }

        List<Integer> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() == maxScore) {
                result.add(Integer.parseInt(student.getName()));
            }
        }

        return result;
    }

    static class Student {
        private final String name;
        private final int[] pattern;
        private int score = 0;

        public Student(String name, int... pattern) {
            this.name = name;
            this.pattern = pattern;
        }

        public void evaluateAnswers(int[] answers) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == pattern[i % pattern.length]) {
                    score++;
                }
            }
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
    }
}
