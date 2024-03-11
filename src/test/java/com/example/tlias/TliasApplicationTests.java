package com.example.tlias;

import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJwt(){
        Jwts.builder().signWith()
    }

}
