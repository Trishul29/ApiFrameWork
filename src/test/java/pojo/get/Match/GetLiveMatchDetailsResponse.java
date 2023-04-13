package pojo.get.Match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class GetLiveMatchDetailsResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;

    private boolean success;

    private String error;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true,value="dls")
    public static class Data
    {
        private Bowler bowler;

        private int overCount;

        private String isMultiDay;

        private int overBalls;

        private Teams[] teams;

        private ProcessDismissal processDismissal;

        private MatchResult matchResult;

        private int totalOvers;

        private boolean isWagonWheelEnabled;

        private String lastBatsmanPair;

        private String[] superOver;

        private String dls;

        private String followOn;

        private MatchStatus matchStatus;

        private Striker striker;

        private String[] currentBalls;

        private Inning inning;

        private NonStriker nonStriker;

        private ExtraDetails extraDetails;

        private String hasSuperOver;

        private boolean isPitchMapEnabled;

        private String overBowlingSide;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Teams
    {
        private Score score;

        private String battingStatus;

        private boolean winningTeam;

        private String isVerified;

        private String name;

        private String primaryColor;

        private String logo;

        private String id;

        private String team;

        private String shortName;

        private int overs;

        private String secondaryColor;

    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Score
    {

        private int ballsPlayed;

        private int runs;

        private int wickets;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MatchStatus
    {
        private String reason;

        private String description;

        private String status;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtraDetails{
        private int noBall;

        private int wide;

        private int legBye;

        private int bye;
    }
    @Getter
    public static class Bowler
    {private String firstName;

        private String lastName;

        private Stats stats;

        private String id;}
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Stats
    {
        private int maidenOvers;

        private int overs;

        private int runs;

        private int wickets;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Striker
    {

        private String firstName;

        private String lastName;

        private Stats stats;

        private String id;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProcessDismissal
    {
        private String batsman;

        private String status;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MatchResult
    { private MatchResultDetails matchResultDetails;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MatchResultDetails
    {
        private Object unspecified;

        private Object specified;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Inning
    {
        private int inningNumber;

        private String battingTeam;

        private String createdAt;

        private String bowlingTeam;

        private int __v;

        private String _id;

        private ExtraDetails extraDetails;

        private String matchId;

        private String updatedAt;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NonStriker
    {
        private String firstName;

        private String lastName;

        private Stats stats;

        private String id;
    }

    public void assertCurrentMatchDetails() {
        assertTrue(this.success,"Success Failure");
        assertTrue(this.getResponseTime()<2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getStatusCode(),200,"Request Failure");

    }
}
