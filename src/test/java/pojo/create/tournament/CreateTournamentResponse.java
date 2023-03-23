package pojo.create.tournament;
import lombok.Getter;
import lombok.Setter;
import static org.testng.Assert.*;

@Getter
public class CreateTournamentResponse {
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
        private String tournamentId;

        private String link;

    }

    public void assertCreateTournamentDetails(CreateTournamentRequestBody createTournamentRequestBody)
    {
        assertEquals(this.getSuccess(),"true");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.getResponseTime()<=3);
        assertNotNull(this.getData().getTournamentId());
        assertNotNull(this.getData().getLink());


    }

}