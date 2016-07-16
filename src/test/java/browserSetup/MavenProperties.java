package browserSetup;

import java.io.IOException;
import java.util.Properties;

public class MavenProperties {
    public MavenProperties() {
    }

    public static String getMavenProperty(String mvnProperty) {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader()
                    .getResourceAsStream("main.properties"));
        } catch (IOException e) {
            System.out.println("Couldn't read main.properties file.");
            e.printStackTrace();
        }
        return properties.getProperty(mvnProperty);
    }
}