package pojo.create.scoring.toss;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class CreateTossResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    boolean success;
    String data;
    String error;
    public  void assertCreateTossResponse()
    {
     assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200);
      assertTrue(this.getResponseTime()<2000,"Response Taking More than 2 Seconds");
    }
}
