package com.kingcode.projectsvisualization.application.commits;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitRepo extends ElasticsearchRepository<CommitEntity, String> {
}
