package pojo.getAll.recommendedusers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
public class GetRecommendedUsersResponse {
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
        private String hasPrevPage;

        private Docs[] docs;

        private String hasNextPage;

        private String pagingCounter;

        private String nextPage;

        private String limit;

        private String totalPages;

        private String prevPage;

        private String page;

        private String totalDocs;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true, value = {"fUid"})
    public static class Docs
    {
        private String firstName;

        private String lastName;

        private String isPhoneVerified;

        private String fUid;

        private Location location;

        private String _id;

        private String profileImage;

        private Boolean isEmailVerified;

        private int playingRole;
    }
    @Getter
    public static class Location
    {
        private String country;

        private String city;

        private String state;
        private String placeId;
        private String address;
        private double[] coordinates;
    }

    public void assertRecommendedUsers()
    {
        assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getStatusCode(),200,"Not able to get Recommended Users");
        assertEquals(this.getSuccess(),"true","Success Failure ");
    }

}
