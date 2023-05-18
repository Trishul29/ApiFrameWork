package pojo.create.tournament;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import static org.testng.Assert.*;

@Getter
@JsonIgnoreProperties("timestamp")
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
        assertEquals(this.getSuccess(),"true","Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.getResponseTime()<=3000,"Response Taking More than 3 Seconds");
        assertNotNull(this.getData().getTournamentId());
        assertNotNull(this.getData().getLink());


    }

}
