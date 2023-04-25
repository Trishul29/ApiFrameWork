package pojo.get.Tournaments;

import lombok.Getter;
import lombok.Setter;
import pojo.get.Team.GetTeamPlayerAccordingToGameTypeResponse;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

@Getter
public class GetTournamentLeaderBoardResponse {
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

        private String highlightedData;

        private boolean hasNextPage;

        private List<String> otherData;

        private List<Players> players;

        private String pagingCounter;

        private int nextPage;

        private int limit;

        private int totalPages;

        private int prevPage;

        private int page;

        private int totalDocs;
    }

    @Getter
    public static class Players {
        private String teamName;

        private String firstName;

        private String lastName;

        private String highlightedData;

        private String isVerified;

        private String city;

        private List<String> otherData;

        private String rank;

        private String id;

        private String profileImage;
    }

    public void assertGetTournamentLeaderBoardResponse() {
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "RequestFailure");
        assertTrue(this.getResponseTime() <= 2000, "Response Taking More than 2 Seconds");
        assertNotNull(this.getData().highlightedData, "HighLighted Data Not Present");
        assertNotNull(this.getData().otherData, "Other Data Not Present");
        for (Players player : this.getData().getPlayers()) {
            System.out.println("player name :" + player.getFirstName() + " And Rank is:" + player.rank);
            assertNotNull(player.getId(), "player not present");
            assertNotNull(player.getRank(), "Rank Not present");
            assertNotNull(player.getFirstName(), "FirstName of Player Not Present");
            assertNotNull(player.getHighlightedData(), "Highlighted Data for player is not present");
            for (String otherData : player.getOtherData()) {
                System.out.println("data is" + otherData);
                assertNotNull(otherData, "Some Other Data is missing");

            }

            assertNotNull(player.getOtherData(), "Other Data Of player Not present");
        }

    }

}
