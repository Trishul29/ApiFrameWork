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
    //  private EditMatchRequestBody.RosterDetails[]rosterDetails1;
    MatchesService matchesService;

    @BeforeMethod
    public void beforeClass() {
        rosterDetails = new EditMatchRequestBody.RosterDetails[5];
        rosterDetails[0] = new EditMatchRequestBody.RosterDetails(true, true, true, new DatabaseUtility().getPlayer_1());
        rosterDetails[1] = new EditMatchRequestBody.RosterDetails(false, false, false, new DatabaseUtility().getPlayer_2());
        rosterDetails[2] = new EditMatchRequestBody.RosterDetails(false, false, false, new DatabaseUtility().getPlayer_3());
        rosterDetails[3] = new EditMatchRequestBody.RosterDetails(false, false, false, new DatabaseUtility().getPlayer_4());
        rosterDetails[4] = new EditMatchRequestBody.RosterDetails(false, true, false, new DatabaseUtility().getPlayer_5());
        matchesService = new MatchesService();

    }

    @Test
    public void shouldEditMatch() {

        EditMatchRequestBody editMatchRequestBody = new EditMatchRequestBody.Builder()
                .setMatchVenue(new EditMatchRequestBody.Address(Faker.instance().regexify("[A-Z0-9_-]{12}"), Faker.instance(new Locale("en_IND")).address().city(), Faker.instance(new Locale("en_IND")).address().country()), new EditMatchRequestBody.GroundName(Faker.instance().regexify("[A-Z0-9_-]{20}"), Faker.instance(new Locale("en_IND")).address().city()), Faker.instance(new Locale("en_IND")).address().latitude(), Faker.instance(new Locale("en_IND")).address().longitude())
                .setTeamOne(properties.getProperty("edit_match_teamId"), false, rosterDetails)
                .setOfficialsId("", "", properties.getProperty("scorer_id"), "640ec20d35ba5e3e6088b258", "", properties.getProperty("streamer_id"))
                .build();
        EditMatchResponse editMatchResponse;
        editMatchResponse = matchesService.editMatchDetails(editMatchRequestBody);
        editMatchResponse.assertEditMatch(editMatchRequestBody);

    }
}
