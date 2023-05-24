package com.resumelibrary.cucumber;

import com.resumelibrary.utilities.PropertyFileReader;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webdriverprovider.WebDriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Hooks extends Utility {

    List<String> tagNames;
    Map<String, Object> threadMapObj;
    PropertyFileReader propertyFileReader;
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private static final String TEST_STATUS_SCRIPT = "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"%s\", \"name\": \"%s\"}}";

    @Before
    public void before() {
    }

    @After (order = 10)
    public void tearDown(Scenario scenario) {
        boolean status = true;
        try {
            if (scenario.getSourceTagNames().contains("@skip_hooks")) {
                logger.info(
                  "[--->In Hooks, cucumber after tearDown method, driver not initialized so don't need to quit driver ----> " + scenario.getSourceTagNames() + "<---]");
            } else {
                logger.info("[--->In Hooks, cucumber after tearDown method ---> " + "<---]");
                if (scenario.isFailed()) {
                    ((JavascriptExecutor) getThreadDriver()).executeScript("lambda-status=failed");
                    scenario.log("[--->--------------------------------------------" + "<---]");
                    scenario.log("[--->CURRENT URL IS ----> " + getPresentURL() + "<---]");
                    scenario.log("[--->BROWSER NAME   ----> " + getBrowserName() + "<---]");
                    scenario.log("[--->CURRENT TAG IS : " + scenario.getSourceTagNames() + "<---]");
                    scenario.log("[--->--------------------------------------------" + "<---]");
                    getScreenshot(scenario);

                } else {
                    try{
                        ((JavascriptExecutor) getThreadDriver()).executeScript("lambda-status=passed");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
//                    if (System.getProperty("browserName").contains("lambda")) {
                    //                        ((JavascriptExecutor) getThreadDriver()).executeScript("lambda-status=passed");
                    //                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        WebDriver driver = (WebDriver) WebDriverProvider.threadLocalMap.get().get("webdriverObj");
        driver.quit();
    }
}