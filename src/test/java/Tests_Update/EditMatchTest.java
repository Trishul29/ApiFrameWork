package Tests_Update;

import com.github.javafaker.Faker;
import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.update.match.EditMatchRequestBody;
import pojo.update.match.EditMatchResponse;
import util.FileUtility;

import java.util.Locale;
import java.util.Properties;

public class EditMatchTest {
    public String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties = FileUtility.loadProperties(propertyPath);
   private EditMatchRequestBody.RosterDetails[] rosterDetails;
  //  private EditMatchRequestBody.RosterDetails[]rosterDetails1;
    MatchesService  matchesService;

    @BeforeMethod
    public void beforeClass()
    {
rosterDetails=new EditMatchRequestBody.RosterDetails[3];
rosterDetails[0]=new EditMatchRequestBody.RosterDetails(true,true,true,"62e114d5c905580636902b30");
rosterDetails[1]=new EditMatchRequestBody.RosterDetails(true,false,false,"62e114e2c905580636902b3b");
rosterDetails[2]=new EditMatchRequestBody.RosterDetails(true,true,false,"62e11503c905580636902b46");
matchesService=new MatchesService();

    }

   @Test
    public void shouldEditMatch()
    {

EditMatchRequestBody editMatchRequestBody=new  EditMatchRequestBody.Builder()
       .setMatchVenue(new EditMatchRequestBody.Address(Faker.instance().regexify("[A-Z0-9_-]{12}"),Faker.instance(new Locale("en_IND")).address().city(),Faker.instance(new Locale("en_IND")).address().country()),new EditMatchRequestBody.GroundName(Faker.instance().regexify("[A-Z0-9_-]{20}"), Faker.instance(new Locale("en_IND")).address().city()), Faker.instance(new Locale("en_IND")).address().latitude(), Faker.instance(new Locale("en_IND")).address().longitude())
        .setTeamOne(properties.getProperty("edit_match_teamId"),false,rosterDetails)
        .setOfficialsId("","",properties.getProperty("scorer_id"),"640ec20d35ba5e3e6088b258","",properties.getProperty("streamer_id"))
        .build();
        EditMatchResponse editMatchResponse;
        editMatchResponse=matchesService.editMatchDetails(editMatchRequestBody);
        editMatchResponse.assertEditMatch(editMatchRequestBody);

    }
}
