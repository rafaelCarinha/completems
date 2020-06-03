package com.completems.repository.dynamo;

import com.completems.model.DynamoUser;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface DynamoUserRepository extends CrudRepository<DynamoUser, String> {
}
