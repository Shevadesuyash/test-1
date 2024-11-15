//package com.example.test_1.model;
//
//import org.apache.ignite.cache.query.annotations.QuerySqlField;
//
//import java.io.Serializable;
//
//public class Person implements Serializable {
//    /** Indexed field. Will be visible to the SQL engine. */
//    @QuerySqlField(index = true)
//    private long id;
//
//    /** Queryable field. Will be visible to the SQL engine. */
//    @QuerySqlField
//    private String name;
//
//    /** Will NOT be visible to the SQL engine. */
//    private int age;
//
//    /**
//     * Indexed field sorted in descending order. Will be visible to the SQL engine.
//     */
//    @QuerySqlField(index = true, descending = true)
//    private float salary;
//}