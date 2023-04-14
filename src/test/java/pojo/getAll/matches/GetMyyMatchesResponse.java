package pojo.getAll.matches;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import static org.testng.Assert.*;

@Getter
public class GetMyyMatchesResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private List<Data> data;

    private boolean success;

    private String error;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true,value = {"link","isWagonWheelEnabled","matchVenue","logoOverlay","showScoreTicker","officials","mvp","currentViewers","multiDayDetails"})
    public static class Data{
        private String matchType;

        private String link;

        private String matchState;

        private String isWagonWheelEnabled;

        private String overPerBowler;

        private MatchVenue matchVenue;

        private String ballType;

        private LogoOverlay logoOverlay;

        private String showScoreTicker;

        private MatchStatus matchStatus;

        private String tournamentName;

        private String isLive;

        private List<String> multiDayDetails;

        private Officials[] officials;

        private TeamTwo teamTwo;

        private String startsAt;

        private String id;

        private String isPitchMapEnabled;

        private String matchVideo;

        private String matchLiveJobId;

        private String visible;

        private Mvp mvp;

        private String currentViewers;

        private String totalOvers;

        private String teamSize;

        private String createdBy;

        private String[] matchVideos;

        private String[] matchVideoUrls;

        private TeamOne teamOne;

        private String userRole;

        private String[] managers;

    }
    @Getter
    public static class MatchVenue{}
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TeamOne{
        private String id;
        private String name;
        private String shortName;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TeamTwo
    {
        private String id;
        private String name;
        private String shortName;
    }
    @Getter
    public static class Mvp{}
    @Getter
    public static class Officials{}
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MatchStatus{
        private String status;
        private String reason;
        private String description;
    }
    @Getter
    public static class LogoOverlay
    {}
    public void assertMyyMatches()
    {
       assertTrue(this.success,"Success Failure");
       assertNotNull(this.getData(),"No Data present");

        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertTrue(this.getResponseTime()<2000,"Response Taking More Than 2 Seconds");
        List<Data> dataList = this.getData();
        for(Data data:dataList)
        {
            assertNotNull(data.getId());
        }
    }
}
