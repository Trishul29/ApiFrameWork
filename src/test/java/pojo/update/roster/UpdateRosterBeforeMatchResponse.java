package pojo.update.roster;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

@Getter
@JsonIgnoreProperties("timestamp")
public class UpdateRosterBeforeMatchResponse {
    @Setter
    int  statusCode;
    @Setter
    long responseTime;

  private   String success;
 private    Data data;
   private String error;

   @Getter
    public static class Data
   {
       private String status;
   }

    public void assertUpdateRosterBeforeMatchResponse(UpdateRosterBeforeMatchRequestBody updateRosterBeforeMatchRequestBody)
    {

        assertEquals(this.success,"true","Success Failure");
        assertTrue(this.getResponseTime()<2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertNotNull(this.getData().getStatus());
        //assertEquals(this.getData().getMessage(),"Match edited successfully","Message not Present");
    }



}
