package com.kingcode.projectsvisualization.application.branches;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends ElasticsearchRepository<BranchEntity, String> {
}
