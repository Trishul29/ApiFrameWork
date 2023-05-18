package pojo.getAll.leaderboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.*;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetAllPlayerLeaderBoardResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;

    private String success;

    private String error;


    @Getter
    public static class Data {


        private String hasPrevPage;

        private List<Docs> docs;

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
    public static class Docs {
        private String strikeRate;

        private String economy;

        private String overs;

        private User user;

        private String matches;

        private String wickets;

        private String runs;
        private float average;
        private int fours;
        private int sixes;

    }

    @Getter
    public static class User {
        private String firstName;

        private String lastName;

        private String city;

        private String isVerified;

        private String link;

        private String profileImage;

        private String _id;

    }


    public void assertLeaderBoardResponseForBatting() {

        assertTrue(this.getResponseTime() < 3000, "Response Taking More than 3 Seconds");
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "Request Unsuccessfull");
        System.out.println(this.getData().getDocs().size()+":size");
        assertTrue(this.getData().getDocs().size()!=0);

        for (Docs doc : this.getData().getDocs()) {
            assertNotNull(doc.getUser().get_id(), "User not present ");
            assertNotNull(doc.getUser().getFirstName(), "first Name not present");
            assertNotNull(doc.getStrikeRate(), "Strike rate Not present");
            assertNotNull(doc.getRuns(), "Runs of batsman not present");
        }


    }
    public void assertLeaderBoardResponseForBowling() {

        assertTrue(this.getResponseTime() < 3000, "Response Taking More than 3 Seconds");
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "Request Unsuccessfull");

        for (Docs doc : this.getData().getDocs()) {
            assertNotNull(doc.getUser().get_id(), "User not present ");
            assertNotNull(doc.getUser().getFirstName(), "first Name not present");
            assertNotNull(doc.getWickets(), "Wickets not present Not present");
            assertNotNull(doc.getOvers(), "Overs  not present");
            assertNotNull(doc.getEconomy(),"Economy Not Present");
        }


    }

}
