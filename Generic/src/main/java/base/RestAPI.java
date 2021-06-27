package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RestAPI {
    protected String apiKey;
    protected String apiSecretKey;
    protected String accessToken;
    protected String accessTokenSecret;
    protected Properties properties;
    protected InputStream inputStream;
    protected String baseUrl;
    protected String apiVersion = "1.1";

    public Properties loadProperties(String path) throws IOException {
        this.properties = new Properties();
        this.inputStream = new FileInputStream(path);
        this.properties.load(this.inputStream);
        return this.properties;
    }

    public RestAPI() {
        // https://api.twitter.com/1.1
        this.baseUrl = "https://api.twitter.com/" + this.apiVersion;
        this.properties = new Properties();
        inputStream =null ;
        try {
            // Path of the secret.properties file
            this.properties = loadProperties("../Twitter/secret.properties");
            this.apiKey = this.properties.getProperty("apiKey");
            this.apiSecretKey = this.properties.getProperty("apiSecretKey");
            this.accessToken = this.properties.getProperty("accessToken");
            this.accessTokenSecret = this.properties.getProperty("accessTokenSecret");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not load properly");
        } finally {
            try {
                this.inputStream.close();
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("File is not closed");
            }
        }
    }

}
