package Test_create;
import com.github.javafaker.Faker;
import modules.service.MatchesService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;
import util.DatabaseUtility;
import util.FileUtility;

import java.util.ArrayList;
import java.util.List;
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

        rosterDetails = new CreateMatchRequestBody.RosterDetails[4];
//        DatabaseUtility dbUtil = new DatabaseUtility();
//        List list = dbUtil.getPlayersTeamOne();

        rosterDetails[0] = new CreateMatchRequestBody.RosterDetails(true, true, false,properties.getProperty("rosterplayer_1"));
        rosterDetails[1] = new CreateMatchRequestBody.RosterDetails(false, false, false, properties.getProperty("rosterplayer_2"));
        rosterDetails[2] = new CreateMatchRequestBody.RosterDetails(false, false, false, properties.getProperty("rosterplayer_3"));
        rosterDetails[3] = new CreateMatchRequestBody.RosterDetails(false, false, false, properties.getProperty("rosterplayer_4"));
       // rosterDetails[4] = new CreateMatchRequestBody.RosterDetails(true, false, false, properties.getProperty("rosterplayer_5"));


        rosterDetails1 = new CreateMatchRequestBody.RosterDetails[4];
        rosterDetails1[0]=new CreateMatchRequestBody.RosterDetails(false,true,false,properties.getProperty("roster_1_player_1"));
        rosterDetails1[1]=new CreateMatchRequestBody.RosterDetails(true,false,false,properties.getProperty("roster_1_player_2"));
        rosterDetails1[2]=new CreateMatchRequestBody.RosterDetails(true,false,false,properties.getProperty("roster_1_player_3"));
        rosterDetails1[3]=new CreateMatchRequestBody.RosterDetails(true,false,false,properties.getProperty("roster_1_player_4"));


    }
    @Test

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

