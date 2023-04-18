package pojo.create.scoring.secondinning;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class StartSecondInningResponse {

        @Setter
        int statusCode;
        @Setter
        float responseTime;
        private  boolean success;

        private String error;
    private Data data;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data
    {

    }


    public void assertSecondInning(StartSecondInningRequestBody startSecondInningRequestBody) {
        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.responseTime<=3000,"Taking More than 3 Seconds");

    }
}

