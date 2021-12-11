package com.kingcode.projectsvisualization.application.projects;

import com.kingcode.projectsvisualization.application.commits.Commit;
import org.kohsuke.github.GHBranch;

public class Branch {

    private String branchName;
    private Commit commit;

    public static Branch toBranch(GHBranch ghBranch) {
        //ToDo implement this method
        return new Branch();
    }
}
