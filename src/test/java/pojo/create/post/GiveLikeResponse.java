package pojo.create.post;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class GiveLikeResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private boolean success;
    private String data;
    private String error;
    public void assertGiveLikeResponse()
    {

        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getData(),"Post updated");
    }
}
