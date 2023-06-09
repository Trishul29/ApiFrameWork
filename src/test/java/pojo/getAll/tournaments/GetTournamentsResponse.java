package pojo.getAll.tournaments;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetTournamentsResponse {
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
    public static class Docs
    {
        private String owner;

        private String gameType;

        private String endDate;

        private String isVerified;

        private String matchType;

        private String totalOvers;
        private String createdBy;

        private String link;

        private String edition;

        private String overPerBowler;

        private String[] matches;

        private String ballType;

        private String createdAt;

        private String followers;

        private String[] sponsors;

        private String name;

        private String logo;

        private String postCount;

        private String noOfPlayers;

        private String _id;

        private String[] rounds;

        private String startDate;

        private String[] managers;

        private Status status;
        private String description;
    }

    @Getter
    public static class Status
    {
        private String status;
    }

    public void assertGetAllTournamentsResponse()
    {
        assertTrue(this.getResponseTime()<=2000,"Response Taking More than 2 Seconds");
        assertEquals(this.getStatusCode(),200,"Not able to get Recommended Users");
        assertEquals(this.getSuccess(),"true","Success Failure ");
        assertNotNull(this.getData().getDocs()[0].get_id(),"tournament not present");
        assertNotNull(this.getData().getDocs()[0].getGameType(),"Game type is not given");
        assertNotNull(this.getData().getDocs()[0].getName(),"Tournament name is not present");

    }


}
