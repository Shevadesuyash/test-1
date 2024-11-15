package com.example.test_1;


import jakarta.annotation.PostConstruct;
import org.apache.ignite.Ignite;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IgniteTestService {

    @Autowired
    private static Ignite ignite;

    @PostConstruct
    public static void testCacheConnection() {
        CacheConfiguration<Long, String> cacheConfig = new CacheConfiguration<>("testCache");
        var cache = ignite.getOrCreateCache(cacheConfig);

        // Sample put and get operations
        cache.put(1L, "Hello Ignite");
        System.out.println("Cache Value: " + cache.get(1L));
    }
}
