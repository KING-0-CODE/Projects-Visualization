package com.kingcode.projectsvisualization.application.projects;

import org.kohsuke.github.GHIssue;

import java.util.List;

public class Issue {
    private int number;
    private String body;
    private int comments;
    private String state;
    private String title;
    private String closed_at;
    private List<String> labels;

   public static Issue toIssue(GHIssue ghIssue) {
        //ToDo: implement this method
        return new Issue();
    }
}
