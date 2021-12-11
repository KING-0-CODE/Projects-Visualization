package com.kingcode.projectsvisualization.application.commits;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Commit {
    @Id
    private String id;
    private Date createdAt;
    private String title;
    private String message;
    private String authorName;
    private String authorEmail;
}