package com.azurealstn.codespringweb.persistence;

import com.azurealstn.codespringweb.mapper.TimeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
@MapperScan(basePackages = "com.azurealstn.codespringweb")
public class TimeMapperTest {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {
        log.info("class: " + timeMapper.getClass().getName());
        log.info("time: " + timeMapper.getTime());
    }
}
