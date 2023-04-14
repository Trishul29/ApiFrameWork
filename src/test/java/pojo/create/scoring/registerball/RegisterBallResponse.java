package pojo.create.scoring.registerball;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import pojo.create.scoring.registerball.RegisterBallRequestBody;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

@Getter
public class RegisterBallResponse {
    @Setter
    int statusCode;

    @Setter
    float responseTime;
    private Data data;

    private boolean success;

    private String error;
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data
    {
        private Bowler bowler;

        private float overCount;

        private boolean isMultiDay;

        private int overBalls;

        private Teams[] teams;

        private ProcessDismissal processDismissal;

        private MatchResult matchResult;

        private String isWagonWheelEnabled;

        private boolean lastBatsmanPair;

        private String[] superOver;

        private Object dls;

        private boolean followOn;

        private MatchStatus matchStatus;

        private Striker striker;

        private List<CurrentBalls> currentBalls;

        private Inning inning;

        private NonStriker nonStriker;

        private ExtraDetails extraDetails;

        private boolean hasSuperOver;

        private boolean isPitchMapEnabled;

        private String overBowlingSide;

        private String currentPartnership;
    }
    @Getter
    public static class Bowler
    {
        private String firstName;

        private String lastName;

        private Stats stats;

        private String id;
    }
    @Getter
    public static class Stats
    {
        private float balls;

        private int runs;
        private int maidenOvers;
        private float wickets;
        private float overs;
    }
    @Getter
    public static class Teams{
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

        private float overs;

        private String secondaryColor;
    }
    @Getter
    public static class Score
    {
        private int ballsPlayed;

        private int runs;

        private int wickets;
    }
    @Getter
    public static class ProcessDismissal
    {
        private String batsman;

        private String status;
    }
    @Getter
    public static class MatchResult
    {

        private MatchResultDetails matchResultDetails;
    }
    @Getter
    public static class MatchResultDetails
    {

        private Object unspecified;

        private Object specified;
    }
    @Getter
    public static class MatchStatus
    {
        private String status;
        private String reason;
        private String description;
    }
    @Getter
    public static class Striker
    {
        private String firstName;

        private String lastName;

        private Stats stats;

        private String id;
    }
    @Getter
    public static class CurrentBalls
    {
        private int dismissal;

        private String ballUpdate;

        private int runs;

        private String[] extraType;
    }
    @Getter
    public static class Inning
    {
        private int inningNumber;

        private String battingTeam;

        private String bowlingTeam;

        private String _id;

        private ExtraDetails extraDetails;
    }
    @Getter
    public static class ExtraDetails
    {

        private int noBall;

        private int wide;

        private int legBye;

        private int bye;
    }
@Getter
public static class NonStriker
{
    private String firstName;

    private String lastName;

    private Stats stats;

    private String id;
}
    public void assertRegisterBallResponse(RegisterBallRequestBody registerBallRequestBody)
    {
        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.responseTime<=3000,"Taking More than 3 Seconds");

    }
}
