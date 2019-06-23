package com.tbd.phoneadvice.neo4j.repositories;

import com.tbd.phoneadvice.neo4j.models.NodePhone;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "phones", path = "phones")

@Repository
public interface NodePhoneRepository extends Neo4jRepository<NodePhone, Long> {
    NodePhone findByPhoneID(@Param("phoneID") Long phoneID);
}
