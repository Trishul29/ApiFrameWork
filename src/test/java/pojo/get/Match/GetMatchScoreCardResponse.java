package pojo.get.Match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.*;

@Getter
public class GetMatchScoreCardResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private List<Data> data;

    private String success;

    private String error;



    @Setter
    public static class Data
    {


        private int inningNumber;

        private Score score;

        private float crr;

        private float rrr;

        private Bowlers[] bowlers;

        private String link;

        private List<Batsmen> batsmen;

        private String fallOfWickets;

        private String inningStatement;

        private String yetToBat;

        private ExtraDetails extraDetails;
    }

    @Setter
    public static class Score
    {
        private String team;

        private float overs;

        private int runs;

        private int wickets;

    }
    @Setter
    public static class Bowlers
    {
        private String[] badges;

        private String firstName;

        private String lastName;

        private int overCount;
        @JsonProperty("isBowler")

        private boolean isBowler;

        private int maidenOver;

        private int wicketCount;

        private int ecoRate;

        private String id;

        private String profileImage;

        private int runCount;

    }
    @Setter
    public static class Batsmen
    {
        private String lastName;

        @JsonProperty("isDismissed")
        private boolean isDismissed;

        private int ballsFaced;

        private String profileImage;
        @JsonProperty("isNonStriker")

        private boolean isNonStriker;

        private String[] badges;

        private String firstName;
        @JsonProperty("isStriker")
        private boolean isStriker;

        private int strikeRate;

        private String dismissedStatus;

        private int sixes;

        private String id;

        private int fours;

        private int runs;

    }
    @Setter
    public static class ExtraDetails
    {
        private int noBall;

        private int wide;

        private int legBye;

        private int bye;


        }

    public void assertScoreCard() {

        assertEquals(this.getSuccess(),"true","Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertNotNull(this.getData().lastIndexOf(data));
        assertTrue(this.getResponseTime()<3000,"Response Taking More than 3 Seconds");

    }

}
