package Tests_Monitor;

import modules.service.ScoreCardService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Match.GetMatchScoreCardResponse;

public class GetMatchScoreCardTest {
    ScoreCardService scoreCardService;

    @BeforeClass
    public void beforeClass() {
        scoreCardService = new ScoreCardService();

    }


    @Test
    public void shouldGetMatchScoreCard() {

        GetMatchScoreCardResponse getMatchScoreCardResponse = scoreCardService.getMatchScoreCard();
        getMatchScoreCardResponse.assertScoreCard();

    }
}
