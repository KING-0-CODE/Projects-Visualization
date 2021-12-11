package com.kingcode.projectsvisualization.application.commits;

import lombok.Builder;
import org.kohsuke.github.GHCommit;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.IOException;
import java.util.Date;

@Builder
@Document(indexName = "#{@environment.getProperty('elasticsearch.index.github.commits')}")
public class Commit {

    @Id
    private final String id;
    @Field(type = FieldType.Date)
    private final Date createdAt;
    private final String message;
    private final String authorName;
    private final String authorEmail;

    public static Commit toCommit(GHCommit ghCommit) throws IOException {
        String[] split = ghCommit.getUrl().toString().split("/");
        String id = split[split.length - 1];
        return Commit.builder()
                .id(id)
                .authorEmail(ghCommit.getCommitShortInfo().getAuthor().getEmail())
                .authorName(ghCommit.getCommitShortInfo().getAuthor().getName())
                .message(ghCommit.getCommitShortInfo().getMessage())
                .createdAt(ghCommit.getCommitDate())
                .build();
    }
}