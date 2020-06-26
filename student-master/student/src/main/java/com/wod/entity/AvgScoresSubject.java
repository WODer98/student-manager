package com.wod.entity;

/**
 * @Author：童达
 * @date：2020/6/21 23:42
 */
public class AvgScoresSubject {
    private String courseId;
    private String courseName;
    private float avgScore;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }
}
