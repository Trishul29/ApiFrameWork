package pojo.create.scoring.endinning;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter

public class EndInningResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private  boolean success;
    private Data data;
    private String error;
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data
    {

    }

    public void assertEndInning(EndInningRequestBody endInningRequestBody)

    {
        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.responseTime<=3000,"Taking More than 3 Seconds");
    }
}
