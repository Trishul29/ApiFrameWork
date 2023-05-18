package pojo.update.tournament;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import pojo.update.tournament.EditTournamentRequestBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Getter
@JsonIgnoreProperties("timestamp")
public class EditTournamentResponse {
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
        private TournamentStatus tournamentStatus;

        private int gameType;

        private String isVerified;

        private int matchType;

        private String link;

        private String edition;

        private String description;

        private int overPerBowler;

        private int ballType;

        private String createdAt;

        private String[] sponsors;

        private int __v;

        private String logo;

        private String startsAt;

        private int noOfPlayers;

        private String endsAt;

        private String updatedAt;

        private int totalOvers;

        private String isVisible;

        private String[] matches;

        private String createdBy;

        private String name;

        private String _id;

        private String[] footballMatches;

        private String[] rounds;

        private String[] managers;
    }

    @Getter
    public static class TournamentStatus
    {

        private String status;

    }
public void assertEditTournament(EditTournamentRequestBody editTournamentRequestBody)
{
    assertEquals(this.getStatusCode(),200,"");
    assertEquals(this.getData().getManagers(),editTournamentRequestBody.getManagers());
   assertTrue(this.getResponseTime()<3000,"Taking more than 3 seconds to update the Tournament");
    assertTrue(this.success);
}


}
