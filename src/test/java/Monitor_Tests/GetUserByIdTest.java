package Monitor_Tests;
import Users.service.UsersService;
import pojo.get.GetUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.FileUtility;
import java.util.Properties;
import static org.testng.Assert.assertEquals;

public class GetUserByIdTest {
    private UsersService usersService;
    private static  String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    private static Properties properties;

    @BeforeClass
    public void beforeClass()
    {
       usersService=new UsersService();
        properties = FileUtility.loadProperties(propertyPath);
    }
    @Test
    public void shouldGetUserById()
    {
        String userId=properties.getProperty("userid");
    GetUserResponse getUserResponse=usersService.getUserById(userId);
        assertEquals(getUserResponse.getStatusCode(),200);
        assertEquals(getUserResponse.getSuccess(),"true");
    }
}
