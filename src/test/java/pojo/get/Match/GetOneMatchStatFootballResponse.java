package pojo.get.Match;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class GetOneMatchStatFootballResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;

    private String success;

    private String error;

    @Getter
    public static class Data
    {
        private TeamOneStats teamOneStats;

        private TeamTwoStats teamTwoStats;
    }
    @Getter
    public static class TeamOneStats
    {
        private String corners;

        private String offside;

        private String passes;

        private String throwIns;

        private String blocks;

        private String shotOnTarget;

        private String freeKicks;

        private String shots;

        private String passAccuracy;

        private String goals;
    }
    @Getter
    public static class TeamTwoStats
    {

        private String corners;

        private String offside;

        private String passes;

        private String throwIns;

        private String blocks;

        private String shotOnTarget;

        private String freeKicks;

        private String shots;

        private String passAccuracy;

        private String goals;

    }



    public void assertGetOneMatchStatFootball()
    {

        assertEquals(this.getSuccess(),"true","success failure");
        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");

    }
}
