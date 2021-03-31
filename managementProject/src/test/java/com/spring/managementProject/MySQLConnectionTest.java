package com.spring.managementProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySQLConnectionTest {
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://127.0.0.1:3306/board?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
	static final String USERNAME = "admin";
	static final String PASSWORD = "password";

	@Test
	public void getMySQLConnectionTest() {

		final Logger logger = LoggerFactory.getLogger(this.getClass());
		
		Connection conn = null;
        Statement stmt = null;
        
        try {
            
            logger.info("==================== MySQL Connection START ====================");
            
            Class.forName(DRIVER);	
            
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
 
            String sql = "SELECT BOARD_SUBJECT, BOARD_CONTENT, BOARD_WRITER FROM TB_BOARD";
 
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                String boardSubject = rs.getString("BOARD_SUBJECT");
                String boardContent = rs.getString("BOARD_CONTENT");
                String boardWriter = rs.getString("BOARD_WRITER");
 
                logger.info("boardSubject : {}", boardSubject);
                logger.info("boardContent: {}", boardContent);
                logger.info("boardWriter: {}", boardWriter);
                logger.info("========================================");
                
            }
 
            rs.close();
            stmt.close();
            conn.close();
 
        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        
        logger.info("==================== MySQL Connection END ====================");
    }
}
