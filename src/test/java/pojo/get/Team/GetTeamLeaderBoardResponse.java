package pojo.get.Team;

import Tests_Monitor.Test_Utility.RankCacheUtility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import pojo.get.Tournaments.GetTournamentLeaderBoardResponse;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetTeamLeaderBoardResponse {
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
        private String info;

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

        private int rank;

        private String id;

        private String profileImage;
        private int rankMovement;
    }

    public void assertGetTeamLeaderBoardResponse() {
        assertEquals(this.getSuccess(), "true", "Success Failure");
        assertEquals(this.getStatusCode(), 200, "RequestFailure");
        assertTrue(this.getResponseTime() <= 2000, "Response Taking More than 2 Seconds");
        assertNotNull(this.getData().highlightedData, "HighLighted Data Not Present");
        assertNotNull(this.getData().otherData, "Other Data Not Present");
        assertTrue(this.getData().getPlayers().size() != 0, "No players present");

        for (String otherData : this.getData().otherData) {
            assertNotNull(otherData, "otherData not present");
        }


        for (Players player : this.getData().getPlayers()) {
            // System.out.println("player name :" + player.getFirstName() + " And Rank is:" + player.rank);
            assertNotNull(player.getId(), "player not present");
            assertNotNull(player.getRank(), "Rank Not present");
            assertNotNull(player.getRankMovement(), "Rank movement not present");
            assertNotNull(player.getFirstName(), "FirstName of Player Not Present");
            assertNotNull(player.getHighlightedData(), "Highlighted Data for player is not present");
            assertNotNull(player.getOtherData(), "Other Data Of player Not present");

            for (String otherData : player.getOtherData()) {
                // System.out.println("data is" + otherData);
                assertNotNull(otherData, "Some Other Data is missing");
            }
        }
    }

    public void assertRankingForBattingStrikeRateAndAverage() {
        List<Players> playersList = this.getData().getPlayers();
        for (int i = 0; i < playersList.size() - 1; i++) {
            Players currentPlayer = playersList.get(i);
            Players nextPlayer = playersList.get(i + 1);
            String currentHighlightedData = currentPlayer.getHighlightedData();
            String nextHighlightedData = nextPlayer.getHighlightedData();
            System.out.println("currentdata->" + currentHighlightedData);
            System.out.println("Nextdata->" + nextHighlightedData);
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
            System.out.println("currentdata->" + currentHighlightedData);
            System.out.println("Nextdata->" + nextHighlightedData);
            if (currentHighlightedData.equals(nextHighlightedData)) {
                continue; // Skip the comparison and move to the next pair of players
            }

            assertTrue(Double.parseDouble(currentHighlightedData) < Double.parseDouble(nextHighlightedData), "Highlighted Data comparison failed between players: "
                    + currentPlayer.getFirstName() + " and " + nextPlayer.getFirstName());
        }

    }

    RankCacheUtility rankCache = new RankCacheUtility();

    public void assertRankMovement() {

            List<Players> players = this.getData().getPlayers();

            for (int i = 0; i < players.size() - 1; i++) {
                Players currentPlayer = players.get(i);
                // Retrieve previous rank and rank movement for the current player
                RankCacheUtility.PlayerRank previousPlayerRank = rankCache.getPlayerRank(currentPlayer.getId());
                int previousRank = (previousPlayerRank != null) ? previousPlayerRank.getRank() : currentPlayer.getRank();
                int previousRankMovement = (previousPlayerRank != null) ? previousPlayerRank.getRankMovement() : currentPlayer.getRankMovement();

                // Compare current rank with previous rank and calculate rank movement
                int currentRank = currentPlayer.getRank();
                int currentRankMovement =currentPlayer.getRankMovement();
                System.out.println("Player: " + currentPlayer.getFirstName() + " " + currentPlayer.getLastName());
                System.out.println("Rank: " + currentRank);
                System.out.println("Rank Movement: " + currentRankMovement);

                // Update the rank and rank movement in the cache
                rankCache.updatePlayerRank(currentPlayer.getId(), currentRank, currentRankMovement);

                if (currentRank != previousRank) {
                    // Assert rank and rank movement
                    assertNotEquals(currentRank, previousRank, "Incorrect rank for player: " + currentPlayer.getFirstName());
                    assertNotEquals(currentRankMovement, previousRankMovement, "Incorrect rank movement for player: " + currentPlayer.getFirstName());

                    // Print the rank and rank movement of the current player

                }
            }
        }


    }



