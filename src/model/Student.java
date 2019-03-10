package model;

import java.util.stream.Collectors;

public class Student {
    private String name;
    private String id;
    private Score score;

    public Student(String name, String id, Score score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Score getScore() {
        return this.score;
    }

    public void setScore(String subject, int score) {
        this.score.setScoresBySubjects(subject, score);
    }

    public String generateScoreSheet() {
        return this.name + "|"
                + this.score.getScoresBySubjects().values().stream().map(s -> s.toString()).collect(Collectors.joining("|"))
                + this.score.getAverageScore() + "|" + this.score.getTotalScore();
    }
}
