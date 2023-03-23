package pojo.create.match;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.*;

@Getter
public class CreateMatchResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;

    private boolean success;

    private String error;
    @Getter
    public static class Data
    {
        private String message;

        private String matchId;
    }


    public void assertMatchDetails(CreateMatchRequestBody createMatchRequestBody)
    {
        assertTrue(this.success);
        assertEquals(this.getStatusCode(),200);
        assertEquals(this.getData().getMessage(),"Match created successfully");
        assertNotNull(this.getData().getMatchId());
        assertTrue(this.responseTime<=3);



    }
}
