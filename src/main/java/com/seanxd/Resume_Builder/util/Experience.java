package com.seanxd.Resume_Builder.util;

import java.util.List;

public class Experience {
    private String title;
    private String company;
    private String start;
    private String end;
    private String location;

    private List<String> details;

    public List<String> getDetails() {
        return details;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getLocation() {
        return location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
