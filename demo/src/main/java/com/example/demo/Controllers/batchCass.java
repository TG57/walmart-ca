package com.example.demo.Controllers;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class batchCass {
    //Creating Cluster.Builder object
    Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
    Session session = cluster.connect("Keyspace name ");
}
