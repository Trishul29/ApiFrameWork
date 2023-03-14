package plain_json_response;

import Users.client.MatchHighlightsClient;
import Users.service.MatchOfficialsService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GetHighlightResponse {
    @Setter
            int statusCode;
    MatchHighlightsClient matchHighlightsClient=new MatchHighlightsClient();

    Response response = matchHighlightsClient.getHighlights();
    JsonPath jsonPath = response.body().jsonPath();
    String id = jsonPath.get("data.docs[0].hightlight.id");
    String teamOneId=jsonPath.get("data.docs[0].hightlight.matchId.teamOne.teamId.id");
    String teamTwoId=jsonPath.get("data.docs[0].hightlight.matchId.teamTwo.teamId.id");
    String inning=jsonPath.get("data.docs[0].hightlight.metaData.inning");
    String title=jsonPath.get("data.docs[0].hightlight.metaData.title");
    String score=jsonPath.get("data.docs[0].hightlight.metaData.score");
    float overs=jsonPath.get("data.docs[0].hightlight.metaData.overs");
    int finalScore=jsonPath.get("data.docs[0].hightlight.metaData.totalScore.score");
}
