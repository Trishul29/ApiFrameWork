package pojo.get.Tournaments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.*;


@Getter
@JsonIgnoreProperties("timestamp")
public class GetPointsOfTournamentResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;

    private List<Data> data;

    private String success;

    private String error;

    @Getter
    public static class Data {
        private String round;

        private String id;
        private String tiebreakMethod;
        private Points[] points;

    }

    @Getter
    public static class Points {
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

        private String NRR;
        private String runQuotient;

    }

    public void assertGetPointsOfTournament() {
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "RequestFailure");
        assertTrue(this.getResponseTime() <= 2000, "Response Taking More than 2 Seconds");


    }

    public void assertRunQuotient() {
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "RequestFailure");
        assertTrue(this.getResponseTime() <= 2000, "Response Taking More than 2 Seconds");

        for (Data d : this.getData()) {
            if (d.getTiebreakMethod().equals("runQuotient")) {
                for (Points point : d.getPoints()) {
                    assertNotNull(point.getRunQuotient(), "RunQuotient not present");

                }

            } else {
                for (Points point : d.getPoints()) {

                    assertNotNull(point.getNRR(), "NRR not present");
                }
            }
        }
    }
}
