package plain_json_response;

import Users.client.MatchHighlightsClient;
import Users.client.MatchesClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Getter
public class GetAllMatchesResponse {
MatchesClient matchesClient=new MatchesClient();
 Response response=matchesClient.getAllMatches();
    JsonPath jsonPath = response.body().jsonPath();
    int statusCode = response.getStatusCode();
  long responseTime =response.timeIn(TimeUnit.SECONDS);


Boolean success=jsonPath.getBoolean("success");
String id=jsonPath.get("data.docs[0].id");
String teamOneId=jsonPath.get("data.docs[0].teamOne.id");
String logo=jsonPath.get("data.docs[0].teamOne.logo");
String name=jsonPath.get("data.docs[0].teamOne.name");
String teamTwoName=jsonPath.get("data.docs[0].teamTwo.name");
String teamTwoId=jsonPath.get("data.docs[0].teamTwo.id");
String teamTwoLogo=jsonPath.get("data.docs[0].teamTwo.logo");

String groundName=jsonPath.get("data.docs[0].matchVenue.groundName");
String city=jsonPath.get("data.docs[0].matchVenue.address.city");
String country=jsonPath.get("data.docs[0].matchVenue.address.country");
String status=jsonPath.get("data.docs[0].matchStatus.status");
String reason=jsonPath.get("data.docs[0].matchStatus.reason");
String description=jsonPath.get("data.docs[0].matchStatus.description");
String startsAt=jsonPath.get("data.docs[0].startsAt");
String matchType=jsonPath.get("data.docs[0].matchType");
String ballType=jsonPath.get("data.docs[0].ballType");





}
