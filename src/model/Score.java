package model;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Score {
    private HashMap<String, Integer> scoresBySubjects;

    public Score() {
        this.scoresBySubjects = new HashMap<>();
        this.scoresBySubjects.put("数学", -1);
        this.scoresBySubjects.put("语文", -1);
        this.scoresBySubjects.put("英语", -1);
        this.scoresBySubjects.put("编程", -1);
    }

    public int getTotalScore() {
        return this.scoresBySubjects.values().stream().filter(s -> s != -1).mapToInt(Integer::intValue).sum();
    }

    public double getAverageScore() {
        return this.scoresBySubjects.values().stream().filter(s -> s != -1).collect(Collectors.averagingDouble(Integer::doubleValue));
    }
}
