package com.crm.qa.utils;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class CustomLogger {
    private final Logger logger ;

    public CustomLogger(Class clazz){

        logger =  LogManager.getLogger(clazz.getName());
    }

    public void info(String message) {
        logger.info(message);
        ExtentReportManager.getExtentTest().pass(message);
    }

    public void warn(String message) {
        logger.warn(message);
        ExtentReportManager.getExtentTest().warning(message);

    }

    public void error(String message) {
        logger.error(message);
        ExtentReportManager.getExtentTest().fail(message);
    }


}