package com.logFile.Practice;

import java.util.logging.Logger;

import javax.annotation.Generated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LogFilePractice {
public static void main(String[] args) {
	Logger log= Logger.getLogger(LogFilePractice.class);
	log.info("launching Browser");
}	}
}
