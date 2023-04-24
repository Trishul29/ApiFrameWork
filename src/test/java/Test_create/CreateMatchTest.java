package Test_create;
import com.github.javafaker.Faker;
import modules.service.MatchesService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;
import util.FileUtility;

import java.util.Locale;
import java.util.Properties;

public class CreateMatchTest {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
private   CreateMatchRequestBody.RosterDetails[] rosterDetails;
private   CreateMatchRequestBody.RosterDetails[] rosterDetails1;
    @BeforeMethod
    public  void beforeTest()
    {

        rosterDetails = new CreateMatchRequestBody.RosterDetails[3];
        rosterDetails[0] = new CreateMatchRequestBody.RosterDetails(true, true, true, "62fc3bdc33e526a27a29187f");
        rosterDetails[1] = new CreateMatchRequestBody.RosterDetails(false, true, false, "63a0001d75e9ab0280d66736");
        rosterDetails[2] = new CreateMatchRequestBody.RosterDetails(true, true, false, "628db1876f6ad608f35cf9d3");
        rosterDetails1 = new CreateMatchRequestBody.RosterDetails[2];
        rosterDetails1[0]=new CreateMatchRequestBody.RosterDetails(false,true,false,"636269e82478ae7be40732fa");
        rosterDetails1[1]=new CreateMatchRequestBody.RosterDetails(true,false,false,"638f3f4cf8ffd4a0f36b7d7f");
    }
  //  @Test

    public void shouldCreateMatch()

    {

        CreateMatchRequestBody createMatchRequestBody = new CreateMatchRequestBody.Builder().setManager(new String[]{properties.getProperty("manager_id")})
            .setMatchVenue(new CreateMatchRequestBody.Address(Faker.instance().regexify("[A-Z0-9_-]{12}"), Faker.instance(new Locale("en_IND")).address().city(), Faker.instance(new Locale("en_IND")).address().country()),
                    new CreateMatchRequestBody.GroundName(Faker.instance().regexify("[A-Z0-9_-]{20}"),Faker.instance(new Locale("en_IND")).country().name()),"28.6862738","77.2217831")
                .setOfficialsId(properties.getProperty("umpire_id"),properties.getProperty("umpire_id"),properties.getProperty("scorer_id"),"","",properties.getProperty("streamer_id"))
                .setTeamOne(properties.getProperty("create_match_teamone_id"),false,rosterDetails)
                .setTeamTwo(properties.getProperty("create_match_teamtwo_id"),false,rosterDetails1)
                .build();

       CreateMatchResponse createMatchResponse = new MatchesService().createMatch(createMatchRequestBody);
       createMatchResponse.assertMatchDetails(createMatchRequestBody);
    }
}

