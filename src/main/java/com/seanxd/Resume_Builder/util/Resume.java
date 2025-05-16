package com.seanxd.Resume_Builder.util;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

public class Resume {
    public String name;
    public String title;
    public String email;
    public String phone;
    public String location;
    public String linkedin;
    public String github;
    public String website;

    public List<String> skills;

    public List<String> getSkills() {
        return skills;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getGithub() {
        return github;
    }

    public String getWebsite() {
        return website;
    }

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public List<Certificate> certificateList = new ArrayList<>();

    public List<Project> projectList = new ArrayList<>();

    private List<Education> educationList = new ArrayList<>();

    private List<Experience> experienceList = new ArrayList<>();

    public List<Education> getEducationList() {
        return educationList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }
}
