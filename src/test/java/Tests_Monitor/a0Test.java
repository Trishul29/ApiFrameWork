//package Tests_Monitor;
//
//import org.junit.Test;
//import util.DatabaseUtility;
//import util.FileUtility;
//
//import java.io.IOException;
//import java.util.Properties;
//
//public class a0Test {
//
//   @Test
//    public void aaa() throws IOException {
//        String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
//        Properties prop = FileUtility.loadProperties(propertyPath);
//
//
//
//        DatabaseUtility databaseUtility = new DatabaseUtility();
//        if (prop.getProperty("base_uri").contains("staging")) {
//            databaseUtility.setDbEnvironment(prop.getProperty("staging_string"));
//            databaseUtility.retrieveDataAndStore();
//
//        } else {
//
//            databaseUtility.setDbEnvironment(prop.getProperty("dev_string"));
//            databaseUtility.retrieveDataAndStore();
//
//        }
//
//    }
//}
