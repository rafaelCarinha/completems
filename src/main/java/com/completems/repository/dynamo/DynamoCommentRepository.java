package com.completems.repository.dynamo;

import com.completems.model.DynamoComment;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface DynamoCommentRepository extends CrudRepository<DynamoComment, String> {
}
