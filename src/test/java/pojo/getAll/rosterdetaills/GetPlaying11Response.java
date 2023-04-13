package pojo.getAll.rosterdetaills;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class GetPlaying11Response {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private List<Data> data;

    private boolean success;

    private String error;
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data
    {
        private boolean isWicketKeeper;

        private String firstName;

        private String lastName;

        private boolean isCaptain;

        private String id;

        private String profileImage;

        private boolean isSubstitute;

    }
    public void assertPlaying11()
    {
        assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getStatusCode(),200,"Not able to get Recommended Users");
        assertTrue(this.success,"Success Failure ");
    }

}
