package plain_json_response;

import Users.client.MatchHighlightsClient;
import Users.client.MatchesClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

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

  public void assertGetAllMatches() {
        assertTrue(this.getResponseTime()<4,"Taking too much time to process request");
        assertTrue(this.getSuccess(),"Success failure");
        assertEquals(this.getStatusCode(),200,"Not able to get All matches");
        assertNotNull(this.getId(),"Match id not present");
        assertNotNull(this.getMatchType(),"MatchType not present");
        assertNotNull(this.getBallType(),"Ball Type not present");
        assertNotNull(this.getName(),"Team 1 name not present");
        assertNotNull(this.getLogo(),"Team 1 logo not presenet");
        assertNotNull(this.getTeamTwoId(),"Team one Id not Present");
        assertNotNull(this.getTeamTwoName(),"Team 2 name not present");
        assertNotNull(this.getTeamTwoLogo(),"Team 2 logo not presenet");
        assertNotNull(this.getTeamTwoId(),"Team 2 Id not Present");
        assertNotNull(this.getCity(),"City not present");
        assertNotNull(this.getCountry(),"Country not present");
        assertNotNull(this.getGroundName(),"Ground name not present");
        assertNotNull(this.getReason(),"Reason not present");
    }





}
