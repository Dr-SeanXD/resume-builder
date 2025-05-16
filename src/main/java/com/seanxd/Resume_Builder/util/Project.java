package com.seanxd.Resume_Builder.util;

import java.util.List;

public class Project {
    private String name;
    private String creator;
    private String start;
    private String end;
    public List<String> details;

    public void setName(String name) {
        this.name = name;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public List<String> getDetails() {
        return details;
    }
}
