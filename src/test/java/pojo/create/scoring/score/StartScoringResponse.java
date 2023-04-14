package pojo.create.scoring.score;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartScoringResponse {
    @Setter
    int statusCode;

    @Setter
    float responseTime;
    private  boolean success;
    private String data;
    private String error;
    public void assertStartScoringResponse()
    {
        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.responseTime<=3000,"Taking More than 3 Seconds");

    }
}
