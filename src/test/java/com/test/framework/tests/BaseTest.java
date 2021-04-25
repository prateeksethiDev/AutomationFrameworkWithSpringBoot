package com.test.framework.tests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.test.framework.config.TestConfig;
import com.test.framework.pages.BasePage;

import org.testng.IHookCallBack;
import org.testng.ITestResult;

/**
 * 
 * @author prateek.sethi<br>
 * 
 * @apiNote
 * This class acts as a parent class for all the Test classes.
 * we are overriding the springTestContextPrepareTestInstance method of class AbstractTestNGSpringContextTests to resolve the 
 * webDriver dependency in @BeforeSuite annotated method.
 * Also, this class is annotated with @SpringBootTest, which bootstrap the entire container. This will create a ApplicationContext 
 * that will be utilized in our tests.
 *
 */
@ContextConfiguration(classes = {TestConfig.class})
public class BaseTest extends AbstractTestNGSpringContextTests{
	
	@Override
    public void run(@NonNull IHookCallBack callBack, ITestResult testResult) {
        String msg = "[BeforeTestExecution] Commencing to run " + testResult.getMethod().getQualifiedName()
                     + "() on thread " + Thread.currentThread().getId();
        System.err.println(msg);
        WebDriver driver = applicationContext.getBean(WebDriver.class);
        super.run(callBack, testResult);
        driver.quit();
    }

    public final <T extends BasePage> T getPage(Class<T> type) {
        return this.applicationContext.getBean(type);
    }
}