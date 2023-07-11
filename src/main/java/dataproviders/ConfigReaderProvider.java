package dataproviders;

import enums.BrowserDriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderProvider {

    private final Properties properties;

    public ConfigReaderProvider() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String propertyFilePath = "src/main/resources/configuration.properties";

        try {
            fileReader = new FileReader(propertyFilePath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();

            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getUrl() {
        String url = properties.getProperty("url");

        //Simply If...Else
        if (url != null) return url;
        else
            throw new RuntimeException("url is missing in the config file.");
    }

    public long getTime() {
        String timeout = properties.getProperty("timeout");

        //Common If...Else
        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout is missing in the config file.");
        }
    }
    public BrowserDriverType getBrowser()  {
        String browserName = properties.getProperty("browser");

        switch (browserName) {
            case "chrome":
                return BrowserDriverType.CHROME;
            case "firefox":
                return BrowserDriverType.FIREFOX;
            case "edge":
                return BrowserDriverType.EDGE;
            case "safari":
                return BrowserDriverType.SAFARI;
            default:
                throw new RuntimeException("Browser name key value in configuration file is not matched,please check...:" + browserName);
        }
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");

        switch (environmentName) {
            case "local":
                return EnvironmentType.LOCAL;
            case "remote":
                return EnvironmentType.REMOTE;
            default:
                throw new RuntimeException("Environment type key value in configuration file is not matched: " + environmentName);
        }
    }

}
