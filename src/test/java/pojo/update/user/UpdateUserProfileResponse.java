package pojo.update.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@JsonIgnoreProperties("timestamp")
public class UpdateUserProfileResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;

    private boolean success;
    private String data;
    private String error;
    public void assertEditUserProfile(UpdateUserProfileRequestBody updateUserProfileRequestBody)
    {
        assertTrue(this.success,"success failure");
        assertEquals(this.getData(),"Updated user details","User details not updated");
        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertTrue(this.getResponseTime()<=1000,"Response Taking More than 2 Seconds");


    }
}
