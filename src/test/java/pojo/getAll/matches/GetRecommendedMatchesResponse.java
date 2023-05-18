package pojo.getAll.matches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@Setter
@JsonIgnoreProperties("timestamp")
public class GetRecommendedMatchesResponse {
    int statusCode;
    long responseTime;
    private Data data;

    private boolean success;

    private String error;

    @Getter
    public static class Data
    {

        private List<Docs> docs;

        private String type;
        private String id;

    }
    @Getter
    public static class Docs
    {
        private String activeMatchUpdatedAt;

        private Teams[] teams;

        private String[] scores;

        private String matchType;

        private String link;

        private MatchVenue matchVenue;

        private String[] badges;

        private String winningTeamIndex;

        private String matchStatus;

        private String tournamentName;

        private String battingTeamIndex;

        private String createdBy;

        private String startsAt;

        private String id;

        private String userRole;

        private String[] managers;
    }
@Getter
public static class Teams
{
    private String isVerified;

    private String name;

    private String primaryColor;

    private String logo;

    private String id;

    private String shortName;

    private String secondaryColor;

}
@Getter
public static class MatchVenue
{

    private Address address;

    private Weather weather;

    private String name;

    private String[] bowlingEnds;

    private String id;

    private String groundName;
}
@Getter
public static class Address
{

    private String country;

    private String city;

    private String street;

    private String placeId;
}
@Getter
public static class Weather
{
    private String unit;

    private String temperature;

    private String icon;

    private String weatherCondition;

}

    public void assertRecommendedMatches()
    {
        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertTrue(this.getResponseTime()<2000,"Response Taking More Than 2 Seconds");
       // assertEquals();

    }

}
