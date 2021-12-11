package com.kingcode.projectsvisualization.application.projects;

import org.kohsuke.github.GHPullRequest;

public class PullRequest {

    private int review_comments;
    private int additions;
    private int commits;
    private boolean merged;

    public static PullRequest toPullRequest(GHPullRequest ghPullRequest) {
        //ToDo:implement this method
        return new PullRequest();
    }
}
