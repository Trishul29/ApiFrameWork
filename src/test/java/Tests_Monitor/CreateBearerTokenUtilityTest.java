package Tests_Monitor;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
public class CreateBearerTokenUtilityTest {
@BeforeSuite
public  void getToken() throws FileNotFoundException {
     String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";


    try {
        RequestSpecification request = RestAssured.given()
                .urlEncodingEnabled(false)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .queryParam("key", "AIzaSyAPiKvVLzQf77Cf3IbGJJhsCfQhefPi2p0")
                .body("{\"email\":\"troops@google.com\",\"password\":\"troops\",\"returnSecureToken\":true}");

        Response response = request.post("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        String token = response.jsonPath().getString("idToken");
        System.out.println(token);

        Map<String, String> properties = new LinkedHashMap<>();
        try (InputStream input = new FileInputStream(propertyPath)) {
            Properties props = new Properties();
            props.load(input);
            for (String propName : props.stringPropertyNames()) {
                String propValue = props.getProperty(propName);
                properties.put(propName, propValue);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Modify the properties
        properties.put("bearerToken", token);

        // Write the properties back to the file
        try (OutputStream output = new FileOutputStream(propertyPath)) {
            Properties props = new Properties();
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                props.setProperty(entry.getKey(), entry.getValue());
            }
            props.store(output, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    finally {
      return;
    }
    }
}



