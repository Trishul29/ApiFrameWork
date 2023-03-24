package pojo.get.Tournaments;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.*;


@Getter
public class GetPointsOfTournamentResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;

    private Data[] data;

    private String success;

    private String error;

    @Getter
    public static class Data
    {
        private String round;

        private String id;

        private Points[] points;

    }
    @Getter
    public static class Points
    {
        private String teamLogo;

        private String isVerified;

        private int lost;

        private int won;

        private String team;

        private int draw;

        private String _id;

        private String played;
@JsonProperty("GD")
        private int GD;

        private int pts;
@JsonProperty("NRR")
        private int NRR;

    }

    public void assertGetPointsOfTournament()

    {
        assertEquals(this.getSuccess(),"true","Success Failure");
       assertEquals(this.getStatusCode(),200,"RequestFailure");
       assertTrue(this.getResponseTime()<=1000,"Taking too much Time to process Request");



    }


}
