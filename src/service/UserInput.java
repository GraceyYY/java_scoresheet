package service;

import model.Score;
import model.Student;
import model.TheClass;
import tools.Print;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    public static boolean checkStuInfoFormat(String inputInfo) {
        return inputInfo.matches("^[\u4e00-\u9fa5]{2,4}，[0-9]{4}，([\u4e00-\u9fa5]{2}：[0-9]{1,2}[0]?，?)+$");
    }

    public static boolean checkStuIdFormat(String inputId) {
        return inputId.matches("^([0-9]{4}，?)+$");
    }

    public static void processInfoInput(TheClass klass, String input) {
        String[] info = input.split("，");
        String name = info[0];
        String id = info[1];
        if (klass.isStudentInClass(id)) {
            for (int i = 2; i < info.length; i++) {
                String[] scores = info[i].split("：");
                String subject = scores[0];
                int score = Integer.valueOf(scores[1]);
                klass.getStudentById(id).getScore().setScoresBySubjects(subject, score);
            }
        } else {
            Score studentScore = new Score();
            for (int i = 2; i < info.length; i++) {
                String[] scores = info[i].split("：");
                String subject = scores[0];
                int score = Integer.valueOf(scores[1]);
                studentScore.setScoresBySubjects(subject, score);
            }
            Student student = new Student(name, id, studentScore);
            klass.updateStudent(student);
        }
        Print.addSuccessful(name);
    }

    public static List<String> processIdInput(TheClass klass, String input) {
         return Arrays.stream(input.split("，")).filter(id->klass.isStudentInClass(id)).collect(Collectors.toList());
    }
}
