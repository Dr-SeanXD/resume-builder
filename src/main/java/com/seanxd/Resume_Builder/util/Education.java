package com.seanxd.Resume_Builder.util;

import java.util.List;

public class Education {
    private String degree;
    private String institution_name;
    private String start_time;
    private String end_time;
    private String school_location;
    public String gpa;

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setSchool_location(String school_location) {
        this.school_location = school_location;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public void setRelevantCourses(List<String> relevantCourses) {
        this.relevantCourses = relevantCourses;
    }

    public List<String> awards;
    public List<String> relevantCourses;

    public String getDegree() {
        return degree;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getSchool_location() {
        return school_location;
    }

    public String getGpa() {
        return gpa;
    }

    public List<String> getAwards() {
        return awards;
    }

    public List<String> getRelevantCourses() {
        return relevantCourses;
    }
}
