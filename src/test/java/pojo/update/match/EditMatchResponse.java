package pojo.update.match;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.*;

@Getter

public class EditMatchResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;

    String success;
    Data data;
    String error;

    @Getter
    public static class Data
    {
        String matchId;
        String message;
    }

    public void assertEditMatch(EditMatchRequestBody editMatchRequestBody)
    {

        assertEquals(this.success,"true","Success Failure");
        assertTrue(this.getResponseTime()<2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertNotNull(this.getData().getMatchId());
        assertEquals(this.getData().getMessage(),"Match edited successfully","Message not Present");
    }


}
