package model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TheClass {
    private HashMap<String, Student> students;

    public TheClass(HashMap<String, Student> students) {
        this.students = new HashMap<>();
    }

    public HashMap<String, Student> getStudents() {
        return this.students;
    }

    public boolean isStudentInClass(String id) {
        return this.students.containsKey(id);
    }

    public Student getStudentById(String id) {
        return this.students.get(id);
    }

    public void updateStudent(Student student) {
        this.students.put(student.getId(), student);
    }

    public double getAverageOfTotalScore() {
        return this.students.values().stream().map(student -> student.getScore().getTotalScore()).collect(Collectors.averagingDouble(Integer::doubleValue));
    }

    public double getMedianOfTotalScore() {
        int size = this.students.size();
        int index = size / 2;
        List<Integer> totalScores = this.students.values().stream().map(student -> student.getScore().getTotalScore()).sorted().collect(Collectors.toList());
        double median;
        if (size % 2 == 1) {
            median = totalScores.get(index);
        } else {
            median = (totalScores.get(index - 1) + totalScores.get(index)) / 2;
        }
        return median;
    }
}
