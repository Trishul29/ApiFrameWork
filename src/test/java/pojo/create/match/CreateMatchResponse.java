package pojo.create.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.*;

@Getter
@JsonIgnoreProperties("timestamp")
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
        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertEquals(this.getData().getMessage(),"Match created successfully");
        assertNotNull(this.getData().getMatchId());
        assertTrue(this.responseTime<=3000,"Taking More than 3 Seconds");



    }
}
