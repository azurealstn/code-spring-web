package com.azurealstn.codespringweb.persistence;

import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;

public class JDBCTest {

    public static final Logger log = LogManager.getLogger(JDBCTest.class);

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try (Connection conn =
                     DriverManager.getConnection(
                             "jdbc:oracle:thin:@localhost:1521:XE",
                             "my_book",
                             "my_book")) {
            log.info(conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


}
