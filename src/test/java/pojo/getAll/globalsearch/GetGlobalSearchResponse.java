package pojo.getAll.globalsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.*;

@Getter

public class GetGlobalSearchResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;

    private List<Data> data;

    private String success;

    private String error;
    @Getter

    public static class Data{
        private String hasPrevPage;

        private String hasNextPage;

        private int count;

        private int limit;

        private String type;

        private List<Value> value;

    }
@Getter
@JsonIgnoreProperties(ignoreUnknown = true,value = {"team"})

    public static class Value{
    private String firstName;

    private String lastName;

    private String isVerified;

    private String mobile;

    private String location;

    private String id;

    private String profileImage;

    private String email;



    }





    public void assertGlobalSearch() {
        assertEquals(this.getStatusCode(),200,"Request Failure");
        assertEquals(this.getSuccess(),"true","Success Failure");

        assertTrue(this.getResponseTime()<=2000,"Taking more than 2 Seconds to get the response");
        for (int i = 0; i < data.size(); i++) {
            assertNotNull(this.getData().get(i).getType(),"Type is not present");
            assertTrue(this.getData().get(i).getCount()!=0,"No result Found For Entered Text");
        }

    }
}
