package com.kingcode.projectsvisualization.application.projects;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends ElasticsearchRepository<Project, Long> {
}
