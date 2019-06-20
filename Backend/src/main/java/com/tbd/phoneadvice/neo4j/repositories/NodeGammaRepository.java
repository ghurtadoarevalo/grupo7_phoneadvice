package com.tbd.phoneadvice.neo4j.repositories;

import com.tbd.phoneadvice.neo4j.models.NodeGamma;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "gamma", path = "gamma")

@Repository
public interface NodeGammaRepository extends Neo4jRepository<NodeGamma, Long> {

}
