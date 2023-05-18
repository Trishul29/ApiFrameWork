package pojo.create.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

@Getter
@JsonIgnoreProperties("timestamp")
public class
CreateTeamResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;
    private String success;
    private String error;
    @Getter
    public static class Data
    {
        private String owner;

        private String manager;

        private String isVerified;

        private String link;

        private String description;

        private String banner;

        private String teamSecondaryColor;

        private String teamCity;

        private String isActive;

        private String teamPrimaryColor;

        private String createdAt;

        private String __v;

        private String name;

        private String logo;

        private Location location;

        private String _id;

        private String id;

        private String shortName;

        private String[] managers;

        private String updatedAt;
    }
    @Getter
    public static class Location
    {
        private String address;

        private String placeId;

        private String[] coordinates;

        private String lat;
@JsonProperty("long")
        private String _long;
    }

    public void assertTeamDetails(CreateTeamRequestBody createTeamRequestBody)
    {

        assertEquals(this.getStatusCode(),200);
        assertEquals(this.getSuccess(),"true","Success Failure");
        assertTrue(this.getResponseTime()<=3000,"Response Taking More than 3 Seconds");
        assertNotNull(this.getData().get_id());
        assertEquals(this.getData().getName(),createTeamRequestBody.getName());
        assertEquals(this.getData().getShortName(),createTeamRequestBody.getShortName());



    }
}
