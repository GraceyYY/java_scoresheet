package model;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Score implements Serializable {
    private static final long serialVersionUID = 1l;

    private TreeMap<String, Integer> scoresBySubjects;

    public Score() {
        this.scoresBySubjects = new TreeMap<>();
        this.scoresBySubjects.put("数学", 0);
        this.scoresBySubjects.put("语文", 0);
        this.scoresBySubjects.put("英语", 0);
        this.scoresBySubjects.put("编程", 0);
        this.scoresBySubjects.comparator();
    }

    public int getTotalScore() {
        return this.scoresBySubjects.values().stream().filter(s -> s != 0).mapToInt(Integer::intValue).sum();
    }

    public double getAverageScore() {
        return this.scoresBySubjects.values().stream().filter(s -> s != 0).collect(Collectors.averagingDouble(Integer::doubleValue));
    }

    public TreeMap<String, Integer> getScoresBySubjects() {
        return this.scoresBySubjects;
    }

    public void setScoresBySubjects(String subject, int score) {
        this.scoresBySubjects.put(subject, score);
    }
}
