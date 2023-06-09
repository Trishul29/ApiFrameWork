package plain_json_response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.Allure;
import modules.client.MatchesClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import util.FileUtility;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

@Getter
@JsonIgnoreProperties("timestamp")
public class GetMatchesResponse {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public   Properties properties= FileUtility.loadProperties(propertyPath);



    String filter =properties.getProperty("filter_matches_tournament");
    String match_Type=properties.getProperty("type_matches");
    MatchesClient matchesClient=new MatchesClient();
    Response response=matchesClient.getAllMatches(filter);
    JsonPath jsonPath = response.body().jsonPath();




  public  void assertGetMatches( )
  {
      int statusCode = response.getStatusCode();
      long responseTime =response.timeIn(TimeUnit.SECONDS);
      boolean success=jsonPath.getBoolean("success");
      String response_in_mili_seconds=Long.toString(responseTime);
      Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");

      if(match_Type.equals("live"))
      {
          String matchId=jsonPath.get("data.docs[0].id");
          String teamOneName=jsonPath.get("data.docs[0].teams[0].name");
          String teamTwoName=jsonPath.get("data.docs[0].teams[1].name");
          String groundName=jsonPath.get("data.docs[0].matchVenue.groundName");
          String city=jsonPath.get("data.docs[0].matchVenue.address.city");
          String country=jsonPath.get("data.docs[0].matchVenue.address.country");
          String matchType=jsonPath.get("data.docs[0].matchType");
          String matchStatus=jsonPath.get("data.docs[0].matchStatus");

         assertTrue(responseTime<2000,"Taking too much time to process request");
          assertTrue(success,"Success failure");
          assertEquals(statusCode,200,"Not able to get All matches");
          assertNotNull(matchId,"Match id not present");
          assertNotNull(matchType,"MatchType not present");
          assertNotNull(teamOneName,"Team 1 name not present");
          assertNotNull(teamTwoName,"Team 2 name not present");
          assertNotNull(city,"City not present");
          assertNotNull(country,"Country not present");
          assertNotNull(groundName,"Ground name not present");
          assertNotNull(matchStatus,"match status not present");

      }
      else if ( match_Type.equals("end"))
      {
          String matchId=jsonPath.get("data.docs[0].id");
          String teamOneName=jsonPath.get("data.docs[0].teams[0].name");
          String teamTwoName=jsonPath.get("data.docs[0].teams[1].name");
          String groundName=jsonPath.get("data.docs[0].matchVenue.groundName");
          String city=jsonPath.get("data.docs[0].matchVenue.address.city");
          String country=jsonPath.get("data.docs[0].matchVenue.address.country");
          String matchType=jsonPath.get("data.docs[0].matchType");
          String matchStatus=jsonPath.get("data.docs[0].matchStatus");
        //  String reason=jsonPath.get("data.docs[0].matchStatus");
          assertTrue(responseTime<2000,"Taking too much time to process request");
          assertTrue(success,"Success failure");
          assertEquals(statusCode,200,"Not able to get All matches");
          assertNotNull(matchId,"Match id not present");
          assertNotNull(matchType,"MatchType not present");
          assertNotNull(teamOneName,"Team 1 name not present");
          assertNotNull(teamTwoName,"Team 2 name not present");
          assertNotNull(city,"City not present");
          assertNotNull(country,"Country not present");
          assertNotNull(groundName,"Ground name not present");
          assertNotNull(matchStatus,"match status not present");

      }
      //For type=result
      else
      {
          String matchId=jsonPath.get("data.docs[0].id");
          String teamOneName=jsonPath.get("data.docs[0].teams[0].name");
          String teamTwoName=jsonPath.get("data.docs[0].teams[1].name");
          String groundName=jsonPath.get("data.docs[0].matchVenue.groundName");
          String city=jsonPath.get("data.docs[0].matchVenue.address.city");
          String country=jsonPath.get("data.docs[0].matchVenue.address.country");
          String matchType=jsonPath.get("data.docs[0].matchType");
          String matchStatus=jsonPath.get("data.docs[0].matchStatus");

          assertTrue(responseTime<2000,"Taking too much time to process request");
          assertTrue(success,"Success failure");
          assertEquals(statusCode,200,"Not able to get All matches");
          assertNotNull(matchId,"Match id not present");
          assertNotNull(matchType,"MatchType not present");
          assertNotNull(teamOneName,"Team 1 name not present");
          assertNotNull(teamTwoName,"Team 2 name not present");
          assertNotNull(city,"City not present");
          assertNotNull(country,"Country not present");
          assertNotNull(groundName,"Ground name not present");
          assertEquals(matchStatus,"end","match status not present");

      }

  }

}
