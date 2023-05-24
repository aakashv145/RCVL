package com.resumelibrary.webdriverprovider;

import com.resumelibrary.utilities.PropertyFileReader;
import com.resumelibrary.utilities.WebURLHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class hook {
  private static final Logger logger = LogManager.getLogger(WebDriverProvider.class);

  public void remoteLambdaTestingChrome(String testName) {
    HashMap<String, Object> driverMap = new HashMap<>();
    try {
      String username = System.getProperty("userName");
      String accessKey = System.getProperty("userkey");
      ;

      String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
      String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
      String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobname");
      String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

      logger.info("[--->jenkinsBuildNumber = " + buildId + "<---]");
      String project = "[" + jobBaseName + "-Build:" + buildId + "]";
      final String driverURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
      logger.info("[--->driverURL:" + driverURL + "<---]");

      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("browserName", "Chrome");
      caps.setCapability("browserVersion", "100.0");

      HashMap<String, Object> ltOptions = new HashMap<String, Object>();
      ltOptions.put("build", System.getProperty("buildName", "Chrome updated 3"));
      ltOptions.put("project", project);
      ltOptions.put("name", testName);
      ltOptions.put("console", "info");
      ltOptions.put("visual", true);
      ltOptions.put("platformName", "Windows 10");
      ltOptions.put("selenium_version", "4.1.2");
      ltOptions.put("driver_version", "100.0");
      ltOptions.put("resolution", "1920x1080");
      ltOptions.put("network", false);
      ltOptions.put("tunnel", true);
      ltOptions.put("idleTimeout", "1800");
      caps.setCapability("LT:Options", ltOptions);
//      caps.setCapability("tunnelName", "SharedTunnel");
      ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20))
        .readTimeout(Duration.ofMinutes(20));
      WebDriver testDriver = RemoteWebDriver.builder().oneOf(caps).address(driverURL).config(config).build();
      driverMap.put("webdriverObj", testDriver);
      WebDriverProvider.threadLocalMap.set(driverMap);
      System.out.println("threadLocalMap : " + WebDriverProvider.threadLocalMap.get());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Before(order = 100)
  public void initiateBrowser(Scenario scenario) {

    remoteLambdaTestingChrome(scenario.getName());
  }

}
