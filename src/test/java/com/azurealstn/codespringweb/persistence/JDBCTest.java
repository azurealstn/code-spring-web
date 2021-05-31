package com.azurealstn.codespringweb.persistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JDBCTest {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "my_book",
                "my_book"
        )) {
            log.info("conn: " + conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
