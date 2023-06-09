package pojo.get.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.type.NullType;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetUserResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;
    private String success;
    private String error;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true, value = {"fUid"})

    public static class Data
    {

        private String isPlayer;
        private String lastName;
        private String isBlock;
        private String isVerified;
        private String mobileNumber;
        private String fUid;
        private String[] roles;
        private String link;
        private String displayMobileNumber;
        private String footballMatchCount;
        private String bio;
        private String profileImage;
        private String[] posts;
        private String cricketMatchCount;
        private String isEmailVerified;
        private BowlingDetails bowlingDetails;
        private String postCount;
        private String id;
        private String email;
        private String playingRole;
        private BattingDetails battingDetails;
        private String isPhoneVerified;
        private String followStatus;
        private String displayEmail;
        private String firstName;
        private String followers;
        private String following;
        private String gameType;
        private Location location;
    }
    @Getter
    public static class Location
    {
        private String country;
        private String address;
        private String city;
        private String placeId;
        private String state;
        private double[] coordinates;
    }
    @Getter
    public static class BowlingDetails
    { private String bowlingStyle;

        private String bowlingAction;
        private String deliveryType;
        private String bowlingArm;
    }
    @Getter
    public static class BattingDetails
    {
        private String battingOrder;
        private String battingHand;
    }

    public void assertGetUserResponse()
    {

        assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getStatusCode(),200);
        assertEquals(this.getSuccess(),"true","Success Failure");
    }
}
