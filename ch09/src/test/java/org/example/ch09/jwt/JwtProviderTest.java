package org.example.ch09.jwt;

import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.entity.User;
import org.example.ch09.security.MyUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider provider;

    @Test
    void createToken() {

        User user = User.builder()
                .userid("a102")
                .name("김유신")
                .birth("1999-02-11")
                .age(23)
                .role("MANAGER")
                .build();

        String jwt = provider.createToken(user, 1);
        log.info(jwt);
        /*
        eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzcGlyb21ldHJ5bzBvQGdtYWlsLmNvbSIsImlhdCI6MTc4MjM3MTE4MiwiZXhwIjoxNzgyNDU3NTgyLCJ1c2VybmFtZSI6ImExMDIiLCJyb2xlIjoiTUFOQUdFUiJ9.dYzUxSQZ5J8lx1ooJua9IxYGZQjEL5G6ommyQ5mFdOM

        */


    }

    @Test
    void getClaims() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzcGlyb21ldHJ5bzBvQGdtYWlsLmNvbSIsImlhdCI6MTc4MjM3MTE4MiwiZXhwIjoxNzgyNDU3NTgyLCJ1c2VybmFtZSI6ImExMDIiLCJyb2xlIjoiTUFOQUdFUiJ9.dYzUxSQZ5J8lx1ooJua9IxYGZQjEL5G6ommyQ5mFdOM";

        Claims claims = provider.getClaims(token);

        log.info("issuer = {}", claims.getIssuer());
        log.info("issuedAt = {}", claims.getIssuedAt());
        log.info("expiration = {}", claims.getExpiration());
        log.info("username = {}", claims.get("username"));
        log.info("role = {}", claims.get("role"));
    }

    @Test
    void getAuthentication() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzcGlyb21ldHJ5bzBvQGdtYWlsLmNvbSIsImlhdCI6MTc4MjM3MTE4MiwiZXhwIjoxNzgyNDU3NTgyLCJ1c2VybmFtZSI6ImExMDIiLCJyb2xlIjoiTUFOQUdFUiJ9.dYzUxSQZ5J8lx1ooJua9IxYGZQjEL5G6ommyQ5mFdOM";

        Authentication authentication = provider.getAuthentication(token);
        User user = (User) authentication.getPrincipal();

        //User user = details.getUser();

        log.info(user);
    }

    @Test
    void validateToken() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzcGlyb21ldHJ5bzBvQGdtYWlsLmNvbSIsImlhdCI6MTc4MjM3MTE4MiwiZXhwIjoxNzgyNDU3NTgyLCJ1c2VybmFtZSI6ImExMDIiLCJyb2xlIjoiTUFOQUdFUiJ9.dYzUxSQZ5J8lx1ooJua9IxYGZQjEL5G6ommyQ5mFdOM";

        provider.validateToken(token);

    }

    @Test
    void getIssuer() {
    }

    @Test
    void getSecret() {
    }
}