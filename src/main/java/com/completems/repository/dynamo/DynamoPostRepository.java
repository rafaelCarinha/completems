package com.completems.repository.dynamo;

import com.completems.model.DynamoPost;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface DynamoPostRepository extends CrudRepository<DynamoPost, String> {
}
