package com.azurealstn.codespringweb.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);

        log.info("restaurant: " + restaurant);
        log.info("-------------------------------");
        log.info("restaurant.getChef(): " + restaurant.getChef());
    }
}
