package Test_create;
import com.github.javafaker.Faker;
import modules.service.MatchesService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;

import java.util.Locale;

public class CreateMatchTest {
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

        CreateMatchRequestBody createMatchRequestBody = new CreateMatchRequestBody.Builder()
            .setMatchVenue(new CreateMatchRequestBody.Address(Faker.instance().regexify("[A-Z0-9_-]{12}"), Faker.instance(new Locale("en_IND")).address().city(), Faker.instance(new Locale("en_IND")).address().country()),
                    new CreateMatchRequestBody.GroundName(Faker.instance().regexify("[A-Z0-9_-]{20}"),Faker.instance(new Locale("en_IND")).country().name()),"28.6862738","77.2217831")
                .setOfficialsId("6392590e8c49221ec9d39c4c","639258b6344f460d4a50b030","639315474d92fd1e0846a1fd","6392592ac4e600390fce3834","6392589fc4e600390fce3821","639258169ae496b37793785d")
                .setTeamOne("639fffad75e9ab0280d666f0",false,rosterDetails)
                .setTeamTwo("63931a341017665e80fe1722",false,rosterDetails1)
                .build();

       CreateMatchResponse createMatchResponse = new MatchesService().createMatch(createMatchRequestBody);
       createMatchResponse.assertMatchDetails(createMatchRequestBody);
    }
}

