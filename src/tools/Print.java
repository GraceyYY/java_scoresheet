package tools;

import model.Student;

public class Print {
    public static void showInfoFormat() {
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
    }

    public static void showIdFormat() {
        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public static void showInfoFormatErrorHint() {
        System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
    }

    public static void showIdFormatErrorHint() {
        System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public static void addSuccessful(Student student) {
        System.out.println("学生" + student.getName() + "的成绩被添加");
    }

    public static void printScoresheet(String scoresheet) {
        System.out.println(scoresheet);
    }
}
