package nec.demo.common;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {

        private static String url;
        private static String username;
        private static String password;

    private static final Logger logger = LogManager.getLogger(DatabaseConnection.class);


        // Static block to initialize static fields
        static {
            ConfigLoader configLoader = new ConfigLoader();
            url = configLoader.getProperty("db.url");
            username = configLoader.getProperty("db.username");
            password = configLoader.getProperty("db.password");
        }

        public static Connection getConnection() {
            try {
                if (url == null || username == null || password == null) {
                    throw new RuntimeException("Database configuration is incomplete. Please check the configuration file.");
                }

                logger.trace("1.This is a TRACE message.");
                logger.debug("2.This is a DEBUG message.");
                logger.info("3.This is an INFO message.");
                logger.warn("4.This is a WARN message.");

                return DriverManager.getConnection(url, username, password);


            } catch (SQLException e) {
                throw new RuntimeException("Failed to establish database connection.", e);
            }
        }
    }
