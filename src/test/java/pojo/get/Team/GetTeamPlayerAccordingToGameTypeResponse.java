package pojo.get.Team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import pojo.update.roster.UpdateRosterBeforeMatchRequestBody;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

@Getter
public class GetTeamPlayerAccordingToGameTypeResponse {
    @Setter
    int statusCode;

    @Setter
    long responseTime;
    private List<Data> data;

    private String success;

    private String error;
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data{

        private boolean isWicketKeeper;

        private String resourceId;

        private String role;

        private boolean isSuperSub;

        private String resourceName;

        private boolean isCaptain;

        private String playingStatus;

        private String _id;

        private boolean isSubstitute;

        private User user;

    }
    @Getter
    public static class User
    {
        private String firstName;

        private String lastName;

        private String isVerified;

        private String dob;

        private String mobileNumber;

        private Location location;

        private String profileImage;

        private String _id;

        private String id;

        private String email;

        private String playingRole;
    }
    @Getter
    public static class Location
    {
        private String city;
    }

    public void assertGetTeamPlayerAccordingToGameTypeResponse()
    {
        assertEquals(this.getSuccess(),"true","Success Failure");
        assertEquals(this.getStatusCode(),200,"RequestFailure");
        assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");
        for (Data d : this.getData()) {
           assertNotNull(d.getPlayingStatus());
        }

    }

}
