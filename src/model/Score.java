package model;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Score {
    private TreeMap<String, Integer> scoresBySubjects;

    public Score() {
        this.scoresBySubjects = new TreeMap<>();
        this.scoresBySubjects.put("数学", -1);
        this.scoresBySubjects.put("语文", -1);
        this.scoresBySubjects.put("英语", -1);
        this.scoresBySubjects.put("编程", -1);
        this.scoresBySubjects.comparator();
    }

    public int getTotalScore() {
        return this.scoresBySubjects.values().stream().filter(s -> s != -1).mapToInt(Integer::intValue).sum();
    }

    public double getAverageScore() {
        return this.scoresBySubjects.values().stream().filter(s -> s != -1).collect(Collectors.averagingDouble(Integer::doubleValue));
    }
}
