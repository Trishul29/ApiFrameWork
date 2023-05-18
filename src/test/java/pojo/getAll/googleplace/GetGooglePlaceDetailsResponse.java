package pojo.getAll.googleplace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetGooglePlaceDetailsResponse {
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
        private String pincode;

        private String country;

        private String city;

        private String placeId;

        private Geometry geometry;

        private String label;

        private String state;
        private String locality;
    }

    @Getter
    public static class Geometry
    {
        private float lat;
@JsonProperty("long")
        private  long _long;
    }

    public void assertPlaceDetails()
    {
        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertTrue(this.getResponseTime()<2000,"Response Taking More Than 2 Seconds");


    }

}
