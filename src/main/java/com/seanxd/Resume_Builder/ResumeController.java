package com.seanxd.Resume_Builder;

import java.util.ArrayList;
import java.util.Map;

import com.seanxd.Resume_Builder.util.Education;
import com.seanxd.Resume_Builder.util.Experience;
import com.seanxd.Resume_Builder.util.Project;
import com.seanxd.Resume_Builder.util.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Controller
public class ResumeController {

    private void addAttribute(Model model, String name, String attribute) {
        if (attribute != null && !attribute.isBlank()) {
            model.addAttribute(name, attribute);
        }
    }

    @GetMapping("/manual-resume")
    public String manualResume(
            @RequestParam(name = "name", required = false) List<String> nameList,
            @RequestParam(name = "title", required = false) List<String> titleList,
            @RequestParam(name = "email", required = false) List<String> emailList,
            @RequestParam(name = "phone", required = false) List<String> phoneList,
            @RequestParam(name = "location", required = false) List<String> locationList,
            @RequestParam(name = "linkedin", required = false) List<String> linkedinList,
            @RequestParam(name = "github", required = false) List<String> githubList,
            @RequestParam(name = "website", required = false) List<String> websiteList,
            @RequestParam(name = "skills", required = false) List<String> skills,
            @RequestParam(name = "certificateList", required = false) List<String> certificates,
            @RequestParam MultiValueMap<String, String> allParams,
            Model model) {

        String name = (nameList != null && !nameList.isEmpty()) ? nameList.get(0) : null;
        String title = (titleList != null && !titleList.isEmpty()) ? titleList.get(0) : null;
        String email = (emailList != null && !emailList.isEmpty()) ? emailList.get(0) : null;
        String phone = (phoneList != null && !phoneList.isEmpty()) ? phoneList.get(0) : null;
        String location = (locationList != null && !locationList.isEmpty()) ? locationList.get(0) : null;
        String linkedin = (linkedinList != null && !linkedinList.isEmpty()) ? linkedinList.get(0) : null;
        String github = (githubList != null && !githubList.isEmpty()) ? githubList.get(0) : null;
        String website = (websiteList != null && !websiteList.isEmpty()) ? websiteList.get(0) : null;

        addAttribute(model,"name", name);
        addAttribute(model, "title", title);
        addAttribute(model, "email", email);
        addAttribute(model, "phone", phone);
        addAttribute(model, "location", location);
        addAttribute(model, "linkedin", linkedin);
        addAttribute(model, "github", github);
        addAttribute(model, "website", website);
        model.addAttribute("skills", skills);
        model.addAttribute("certifications", certificates);

        // Reconstruct structured experienceList
        List<Experience> experienceList = new java.util.ArrayList<>();
        for (int i = 0; ; i++) {
            String expTitle = allParams.getFirst("experienceList[" + i + "].title");
            String expCompany = allParams.getFirst("experienceList[" + i + "].company");
            String expStart = allParams.getFirst("experienceList[" + i + "].start");
            String expEnd = allParams.getFirst("experienceList[" + i + "].end");
            String expLocation = allParams.getFirst("experienceList[" + i + "].location");

            if (expTitle == null && expCompany == null && expStart == null && expEnd == null && expLocation == null) break;

            Experience exp = new Experience();
            exp.setTitle(expTitle);
            exp.setCompany(expCompany);
            exp.setStart(expStart);
            exp.setEnd(expEnd);
            exp.setLocation(expLocation);

            List<String> details = new java.util.ArrayList<>();
            int detailIndex = 0;
            while (true) {
                String key = "experienceList[" + i + "].details[" + detailIndex + "]";
                List<String> values = allParams.get(key);
                if (values == null) break;
                details.addAll(values);
                detailIndex++;
            }
            exp.setDetails(details);
            experienceList.add(exp);
        }
        model.addAttribute("experienceList", experienceList);

        System.out.println("---- Submitted Params ----");
        allParams.forEach((k, v) -> System.out.println(k + ": " + v));


        // Reconstruct structured educationList
        List<Education> educationList = new java.util.ArrayList<>();
        for (int i = 0; ; i++) {
            String degree = allParams.getFirst("educationList[" + i + "].degree");
            String institution_name = allParams.getFirst("educationList[" + i + "].institution_name");
            String start = allParams.getFirst("educationList[" + i + "].start_time");
            String end = allParams.getFirst("educationList[" + i + "].end_time");
            String school_location = allParams.getFirst("educationList[" + i + "].school_location");
            String gpa = allParams.getFirst("educationList[" + i + "].gpa");

            if (degree == null && institution_name == null && start == null && end == null
                && school_location == null) break;

            Education edu = new Education();
            edu.setDegree(degree);
            edu.setInstitution_name(institution_name);
            edu.setStart_time(start);
            edu.setEnd_time(end);
            edu.setSchool_location(school_location);
            edu.setGpa(gpa);


            // Collect awards
            List<String> awards = new ArrayList<>();
            int awardIndex = 0;
            while (true) {
                String key = "educationList[" + i + "].awards[" + awardIndex + "]";
                List<String> values = allParams.get(key);
                if (values == null) break;
                awards.addAll(values);
                awardIndex++;
            }

            // Collect relevantCourses
            List<String> courses = new ArrayList<>();
            int courseIndex = 0;
            while (true) {
                String key = "educationList[" + i + "].relevantCourses[" + courseIndex + "]";
                List<String> values = allParams.get(key);
                if (values == null) break;
                courses.addAll(values);
                courseIndex++;
            }

            edu.setAwards(awards);
            edu.setRelevantCourses(courses);
            educationList.add(edu);

            System.out.println("Awards: " + awards);
            System.out.println("Courses: " + courses);
        }
        model.addAttribute("educationList", educationList);

        // Reconstruct structured projectList
        List<Project> projectList = new ArrayList<>();
        for (int i = 0; ; i++) {
            String projectName = allParams.getFirst("projectList[" + i + "].name");
            String creator = allParams.getFirst("projectList[" + i + "].creator");
            String start = allParams.getFirst("projectList[" + i + "].start");
            String end = allParams.getFirst("projectList[" + i + "].end");

            if (projectName == null && creator == null && start == null && end == null) break;

            Project proj = new Project();
            proj.setName(projectName);
            proj.setCreator(creator);
            proj.setStart(start);
            proj.setEnd(end);

            List<String> details = new java.util.ArrayList<>();
            int detailIndex = 0;
            while (true) {
                String key = "projectList[" + i + "].details[" + detailIndex + "]";
                List<String> values = allParams.get(key);
                if (values == null) break;
                details.addAll(values);
                detailIndex++;
            }

            proj.setDetails(details);
            projectList.add(proj);
        }
        model.addAttribute("projectList", projectList);

        return "resume";
    }

    @GetMapping("/")
    public String index(@ModelAttribute("resume") Resume form, Model model) {
        return "index";
    }
}
