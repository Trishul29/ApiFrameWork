package pojo.getAll.leaderboard;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.*;

@Getter
public class GetAllPlayerLeaderBoardResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;
    private Data data;

    private String success;

    private String error;
    

    @Getter
    public static class  Data{


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
    public static class Docs{
        private String strikeRate;

        private String economy;

        private String overs;

        private User user;

        private String matches;

        private String wickets;

        private String runs;
        private  float average;
        private  int fours;
        private  int sixes;

    }
    @Getter
    public static class  User
    {
        private String firstName;

        private String lastName;

        private String city;

        private String isVerified;

        private String link;

        private String profileImage;

        private String _id;

    }

    
        public void assertLeaderBoardResponse() {

        assertTrue(this.getResponseTime()<3000,"Response Taking More than 3 Seconds");
        assertEquals(this.getSuccess(),"true","Success Failure");
        assertEquals(this.getStatusCode(),200,"Request Unsuccessfull");
        assertNotNull(this.getData().getDocs()[0].getUser().getFirstName());
        assertNotNull(this.getData().getDocs()[0].getMatches());
        assertNotNull(this.getData().getDocs()[0].getRuns());
        assertNotNull(this.getData().getDocs()[0].getStrikeRate());

        for(int i=0; i< this.getData().getDocs().length;i++)
        {
            assertNotNull(this.getData().getDocs()[i].getUser().get_id());
        }

    }

}
