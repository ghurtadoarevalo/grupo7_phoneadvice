package com.tbd.phoneadvice.neo4j.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Arista {


    private long source;
    private long target;
    private String type;

}
