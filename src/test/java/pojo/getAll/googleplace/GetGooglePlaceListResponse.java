package pojo.getAll.googleplace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.*;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetGooglePlaceListResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private List<Data> data;

    private boolean success;


    private String error;
    @Getter
    public static class Data
    {
        private String description;

        private String type;

        private String place_id;

    }

    public void assertPlaceList()
    {
        assertTrue(this.success,"Success Failure");
        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertTrue(this.getResponseTime()<2000,"Response Taking More Than 2 Seconds");
        this.getData().stream().forEach(dataItem->assertNotNull(dataItem.getDescription(),"Description is not present"));
        this.getData().stream().forEach(dataItem->assertNotNull(dataItem.getType(),"Type is not present"));
        this.getData().stream().forEach(dataItem->assertNotNull(dataItem.getPlace_id(),"Place Id is not present"));

    }




}
