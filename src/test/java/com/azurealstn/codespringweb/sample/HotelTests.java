package com.azurealstn.codespringweb.sample;

import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class HotelTests {

    public static final Logger log = LogManager.getLogger(HotelTests.class);

    @Setter(onMethod_ = {@Autowired})
    private SampleHotel hotel;

    @Test
    public void testExist() {

        assertNotNull(hotel);

        log.info(hotel);
        log.info("--------------");
        log.info(hotel.getChef());
    }
}
