package pojo.get.Match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Getter
@JsonIgnoreProperties("timestamp")
public class GetOneMatch_FootballResponse {
@Setter
    int statusCode;
@Setter
    long responseTime;



    private Data data;

    private String success;

    private String error;
    @Getter
    public static class Data
    {private String[] teamScore;

        private String matchStatus;

        private String halfTimeDuration;

        private Teams[] teams;

        private String matchDuration;

        private String matchResult;

        private Officials[] officials;

        private String startsAt;

        private MatchResultDetails matchResultDetails;

        private String id;

        private Events[] events;

    }

    @Getter
    public static class Events{
        private String timeStamp;

        private String eventTime;

        private String statement;

        private String _id;

        private String event;


    }
    @Getter
    public static class MatchResultDetails {
        private UnSpecified unspecified;

        private Specified specified;
    }
    @Getter
    public static class Specified
    {
        private String winningTeam;
    }
    @Getter
    public static class UnSpecified
    {

    }

    @Getter
    public static class Officials{
        private String firstName;

        private String lastName;

        private String role;

        private String profileImage;

        private String userId;




    }
    @Getter
    public static class Teams
    {
        private String name;

        private String id;

        private String logoURI;

        private String shortName;

    }



public void assertOneMatchFootBall()
{

    assertEquals(this.getSuccess(),"true","success failure");
    assertEquals(this.getStatusCode(),200,"Request Failure");
    assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");

}

}
