package Tests_Update;

import com.github.javafaker.Faker;
import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.get.Tournaments.GetTournamentLeaderBoardResponse;
import pojo.update.match.EditMatchRequestBody;
import pojo.update.match.EditMatchResponse;
import util.DatabaseUtility;
import util.FileUtility;

import java.util.Locale;
import java.util.Properties;

public class EditMatchTest {
    public String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties = FileUtility.loadProperties(propertyPath);
    private EditMatchRequestBody.RosterDetails[] rosterDetails;
    private EditMatchRequestBody.RosterDetails[] rosterDetails1;

    MatchesService matchesService;


    @BeforeMethod
    public void beforeClass() {
        matchesService = new MatchesService();
        rosterDetails = new EditMatchRequestBody.RosterDetails[6];
        rosterDetails[0] = new EditMatchRequestBody.RosterDetails(true, true, true, properties.getProperty("editMatchPlayer_1"));
        rosterDetails[1] = new EditMatchRequestBody.RosterDetails(false, false, false,properties.getProperty("editMatchPlayer_2"));
        rosterDetails[2] = new EditMatchRequestBody.RosterDetails(false, false, false, properties.getProperty("editMatchPlayer_3"));
        rosterDetails[3] = new EditMatchRequestBody.RosterDetails(false, false, false, properties.getProperty("editMatchPlayer_4"));
       rosterDetails[4] = new EditMatchRequestBody.RosterDetails(false, true, false, properties.getProperty("editMatchPlayer_5"));
        rosterDetails1= new EditMatchRequestBody.RosterDetails[0];

    }

    @Test
    public void shouldEditMatch() {

        EditMatchRequestBody editMatchRequestBody = new EditMatchRequestBody.Builder()
                .setMatchVenue(new EditMatchRequestBody.Address(Faker.instance().regexify("[A-Z0-9_-]{12}"), Faker.instance(new Locale("en_IND")).address().city(), Faker.instance(new Locale("en_IND")).address().country()), new EditMatchRequestBody.GroundName(Faker.instance().regexify("[A-Z0-9_-]{20}"), Faker.instance(new Locale("en_IND")).address().city()), Faker.instance(new Locale("en_IND")).address().latitude(), Faker.instance(new Locale("en_IND")).address().longitude())
                .setTeamOne(properties.getProperty("edit_match_teamId"), false, rosterDetails)
                .setTeamTwo(properties.getProperty("Edit_teamTwoId"),false,rosterDetails1).build();


        EditMatchResponse    editMatchResponse = matchesService.editMatchDetails(editMatchRequestBody);
        editMatchResponse.assertEditMatch(editMatchRequestBody);

    }
}
