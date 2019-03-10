package tools;

import model.TheClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Print {
    private List<String> subjects;

    public Print(String[] subjects) {
        this.subjects = Arrays.stream(subjects).sorted().collect(Collectors.toList());
    }

    public void printScoresheet(List<String> studentId, TheClass theClass) {
        String scoresheet = "成绩单\n" +
                        "姓名|" + this.subjects.stream().collect(Collectors.joining("|")) + "|平均分|总分" +
                        "\n========================" +
                        studentId.stream().map(id -> theClass.getStudentById(id).generateScoreSheet()).collect(Collectors.joining("\n", "\n", "\n"))
                        + "========================\n" +
                        "全班总分平均数：" + theClass.getAverageOfTotalScore()
                        + "\n全班总分中位数：" + theClass.getMedianOfTotalScore();
        System.out.println(scoresheet);
    }
}
