package com.example.c196claytondixon.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses",
        foreignKeys = @ForeignKey(entity = TermEntity.class,
                parentColumns = "termID",
                childColumns = "termID", onDelete = ForeignKey.CASCADE))
public class CourseEntity {

    @PrimaryKey(autoGenerate = true)
    private int courseID;

    private String courseTitle;
    private String courseStart;
    private String courseEnd;
    private String courseStatus;
    private String courseNotes;
    private int termID;
    private String courseInstructorName;
    private Long courseInstructorPhoneNumber;
    private String courseInstructorEmail;

    public CourseEntity(int courseID, String courseTitle, String courseStart, String courseEnd, String courseStatus, String courseNotes, int termID,
                        String courseInstructorName, Long courseInstructorPhoneNumber, String courseInstructorEmail) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.courseStatus = courseStatus;
        this.courseNotes = courseNotes;
        this.termID = termID;
        this.courseInstructorName = courseInstructorName;
        this.courseInstructorPhoneNumber = courseInstructorPhoneNumber;
        this.courseInstructorEmail = courseInstructorEmail;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseID=" + courseID +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseStart='" + courseStart + '\'' +
                ", courseEnd='" + courseEnd + '\'' +
                ", courseStatus='" + courseStatus + '\'' +
                ", courseNotes='" + courseNotes + '\'' +
                ", termID=" + termID +
                '}';
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseStart() {
        return courseStart;
    }

    public void setCourseStart(String courseStart) {
        this.courseStart = courseStart;
    }

    public String getCourseEnd() {
        return courseEnd;
    }

    public void setCourseEnd(String courseEnd) {
        this.courseEnd = courseEnd;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseNotes() {
        return courseNotes;
    }

    public void setCourseNotes(String courseNotes) {
        this.courseNotes = courseNotes;
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public String getCourseInstructorName() {
        return courseInstructorName;
    }

    public void setCourseInstructorName(String courseInstructorName) {
        this.courseInstructorName = courseInstructorName;
    }

    public Long getCourseInstructorPhoneNumber() {
        return courseInstructorPhoneNumber;
    }

    public void setCourseInstructorPhoneNumber(Long courseInstructorPhoneNumber) {
        this.courseInstructorPhoneNumber = courseInstructorPhoneNumber;
    }

    public String getCourseInstructorEmail() {
        return courseInstructorEmail;
    }

    public void setCourseInstructorEmail(String courseInstructorEmail) {
        this.courseInstructorEmail = courseInstructorEmail;
    }
}
