package com.tbd.phoneadvice.neo4j.repositories;

import com.tbd.phoneadvice.neo4j.models.NodeBrand;
import com.tbd.phoneadvice.neo4j.models.NodeUser;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "brands", path = "brands")

@Repository
public interface NodeBrandRepository extends Neo4jRepository<NodeBrand, Long> {
    NodeBrand findByBrandID(@Param("brandID") Long brandID);
}