package pojo.get;

import lombok.Getter;
import lombok.Setter;
import org.testng.IReporter;

import static org.testng.Assert.*;

@Getter
public class GetMatchInfoResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;

    private boolean success;

    private String error;
    @Getter
    public static class Data
    {
        private String mvpPostText;

        private MatchStatus matchStatus;

        private WinningTeam winningTeam;

        private String matchType;

        private String winningTeamPostText;

        private Mvp[] mvp;

        private String matchResult;

        private Officials[] officials;

        private String startsAt;

        private String id;

        private String ballType;

        private MatchVenue matchVenue;

    }
    @Getter
    public static class Mvp
    {
        private String firstName;
        private String lastName;
        private String link;
        private String teamShortName;
        private String id;
        private String profileImage;
        private String team;
    }
    @Getter
    public static class WinningTeam
    {
       private String name;
       private String link;
       private String logo;
       private String id;
       private String teamSecondaryColor;

        private String shortName;

        private String teamPrimaryColor;
    }
    @Getter
    public static class MatchStatus
    {

        private String reason;

        private String description;

        private String status;
    }
    @Getter
    public static class Officials
    {
        private String firstName;

        private String lastName;

        private String officialsRole;

        private String id;
        private  String _id;
        private String role;
        private String profileImage;
    }
    @Getter
    public static class MatchVenue
    {
        private Address address;

        private GroundName groundName;
    }
    @Getter
    public static class Address
    {
        private String country;

        private String city;

        private String placeId;
    }
    @Getter
    public static class GroundName
    {
        private String placeId;

        private String name;
    }

    public void assertMatchInfo()
    {
        assertTrue(this.success);
       assertEquals(this.getStatusCode(),200);
       assertTrue(this.getResponseTime()<=3,"Request taking more than 3 Seconds");
      if(this.getData().getMatchStatus().equals("end"))
      {
        assertNotNull(this.getData().getWinningTeam().name,"Team name not Available");
        assertNotNull(this.getData().getMvp()[0].firstName,"mvp First name not present");
          assertNotNull(this.getData().getMvp()[0].lastName,"mvp last name not present");
      }
    }


}
