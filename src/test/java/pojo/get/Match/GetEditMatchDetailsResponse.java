package pojo.get.Match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@JsonIgnoreProperties("timestamp")

public class GetEditMatchDetailsResponse {
    @Setter
    int StatusCode;
    @Setter
    long responseTime;
    private Data data;

    private boolean success;

    private String error;

    @Getter
    public static class Data {
        private String matchType;

        private OfficialsId[] officialsId;

        private int totalOvers;

        private Tournament tournament;

        private int overPerBowler;

        private String ballType;

        private MatchVenue matchVenue;

        private MatchStatus matchStatus;

        private MultiDayDetails multiDayDetails;

        private Round round;

        private CreatedBy createdBy;

        private int teamSize;

        private TeamTwo teamTwo;

        private String startsAt;

        private String id;

        private TeamOne teamOne;

        private Managers[] managers;


    }
    @Getter
    public static class Round
    {
        String name;
        String id;

    }
    @Getter
    public static class Tournament
    {
        String name;
        String id;
    }
    @Getter
    public static class MultiDayDetails
    {

    }
@Getter
public static class MatchStatus
{
    private String status;
}
    @Getter
    public static class Status {

        private String status;
    }

    @Getter
    public static class Managers {

        private String firstName;

        private String lastName;

        private String profileImage;

        private String _id;

        private String id;
    }

    @Getter
    public static class CreatedBy {
        private String firstName;

        private String lastName;

        private String profileImage;

        private String _id;

        private String id;
    }

    @Getter
    public static class OfficialsId {
        private String firstName;

        private String lastName;

        private String profileImage;

        private String _id;

        private String id;
        private String officialsRole;

    }

    @Getter
    public static class MatchVenue {
        private Address address;

        private double latitude;

        private GroundName groundName;

        private double longitude;
    }

    @Getter
    public static class Address {
        private String country;

        private String city;

        private String placeId;
    }

    @Getter
    public static class GroundName {

        private String placeId;

        private String name;
    }
    @Getter
    public static class TeamOne
    {
        private String name;

        private String logo;

        private String teamSecondaryColor;

        private String id;

        private String shortName;

        private RosterDetails[] rosterDetails;

        private String teamPrimaryColor;
    }
    @Getter
    public static class TeamTwo
    {
        private String name;

        private String logo;

        private String teamSecondaryColor;

        private String id;

        private String shortName;

        private RosterDetails[] rosterDetails;

        private String teamPrimaryColor;
    }
@Getter
    public static class RosterDetails
{
    private String isWicketKeeper;

    private String firstName;

    private String lastName;
    @JsonProperty("isCaptain")

    private boolean isCaptain;

    private int battingPlayingStatus;

    private int fieldingPlayingStatus;
    @JsonProperty("isSubstitute")

    private boolean isSubstitute;

    private String profileImage;

    private String id;
    private String isSuperSub;

    private int bowlingPlayingStatus;
}
public void assertFetchEditMatch()
{
    assertTrue(this.getResponseTime()<2000,"Response Taking More than 2 Seconds");
    assertEquals(this.getStatusCode(),200,"Request Failure");

}

}
