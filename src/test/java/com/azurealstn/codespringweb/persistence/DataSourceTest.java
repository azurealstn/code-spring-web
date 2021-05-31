package com.azurealstn.codespringweb.persistence;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@SpringBootTest
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        try (Connection conn = dataSource.getConnection()) {
            log.info("conn: " + conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMyBatis() {
        try (SqlSession session = sqlSessionFactory.openSession();
            Connection conn = session.getConnection();
        ) {
            log.info("session: " + session);
            log.info("conn: " + conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
