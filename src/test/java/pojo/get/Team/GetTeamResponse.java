package pojo.get.Team;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class GetTeamResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;

    public Object data;
    private Object success;
    private Object error;

    @Getter
    public static class Data
    {
        private String owner;
        private String manager;
        private String isVerified;
        private String followStatus;
        private String link;
        private String description;
        private String banner;
        private String teamSecondaryColor;
        private String teamCity;
        private String isActive;
        private String teamPrimaryColor;
        private String followers;
        private String name;
        private String logo;
        private String postCount;
        private Location location;
        private String id;
        private String shortName;
        private String[] managers;

    }
    @Getter
    public static class Location
    {
        private String address;
        private String placeId;
        private String lat;
@JsonProperty("long")
        private String lon;
    }
    public void assertGetTeamResponse()
    { assertTrue(this.getResponseTime()<=2,"Taking too much time to process Request");
        assertEquals(this.getStatusCode(),200,"");
        assertEquals(this.getSuccess(),true);
    }
}
