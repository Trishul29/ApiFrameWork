package pojo.get.Tournaments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import pojo.get.Team.GetTeamPlayerAccordingToGameTypeResponse;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

@Getter
@JsonIgnoreProperties("timestamp")
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
        private String info;

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
        private String rankMovement;
    }

    public void assertGetTournamentLeaderBoardResponse() {
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "RequestFailure");
        assertTrue(this.getResponseTime() <= 2000, "Response Taking More than 2 Seconds");
        assertNotNull(this.getData().highlightedData, "HighLighted Data Not Present");
        assertNotNull(this.getData().otherData, "Other Data Not Present");
        assertNotNull(this.getData().players, "No players present");
        for (String otherData : this.getData().otherData) {
            assertNotNull(otherData, "otherData not present");
        }


        for (Players player : this.getData().getPlayers()) {
            String hd = player.getHighlightedData();
            assertNotNull(player.getId(), "player not present");
            assertNotNull(player.getRank(), "Rank Not present");
            assertNotNull(player.getFirstName(), "FirstName of Player Not Present");
            assertNotNull(player.getHighlightedData(), "Highlighted Data for player is not present");
            for (String otherData : player.getOtherData()) {

                assertNotNull(otherData, "Some Other Data is missing");

            }

            assertNotNull(player.getOtherData(), "Other Data Of player Not present");
        }

    }

    public void assertRankingForBattingStrikeRateAndAverage() {
        List<Players> playersList = this.getData().getPlayers();

        for (int i = 0; i < playersList.size() - 1; i++) {
            Players currentPlayer = playersList.get(i);
            Players nextPlayer = playersList.get(i + 1);
            String currentHighlightedData = currentPlayer.getHighlightedData();
            String nextHighlightedData = nextPlayer.getHighlightedData();
            if (currentHighlightedData.equals(nextHighlightedData)) {
                continue; // Skip the comparison and move to the next pair of players
            }
            assertTrue(Double.parseDouble(currentHighlightedData) > Double.parseDouble(nextHighlightedData), "Highlighted Data comparison failed between players: "
                    + currentPlayer.getFirstName() + " and " + nextPlayer.getFirstName());
        }

    }

    public void assertRankingForBowling() {
        List<Players> playersList = this.getData().getPlayers();

        for (int i = 0; i < playersList.size() - 1; i++) {
            Players currentPlayer = playersList.get(i);
            Players nextPlayer = playersList.get(i + 1);

            String currentHighlightedData = currentPlayer.getHighlightedData();
            String nextHighlightedData = nextPlayer.getHighlightedData();
            if (currentHighlightedData.equals(nextHighlightedData) || nextHighlightedData.equals("0")) {
                continue; // Skip the comparison and move to the next pair of players
            }
//            System.out.println("highlighted current:"+Double.parseDouble(currentHighlightedData));
            assertTrue(Double.parseDouble(currentHighlightedData) < Double.parseDouble(nextHighlightedData), "Highlighted Data comparison failed between players: "
                    + currentPlayer.getFirstName() + " and " + nextPlayer.getFirstName());
        }

    }


}