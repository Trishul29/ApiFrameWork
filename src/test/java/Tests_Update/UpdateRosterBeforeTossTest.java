package Tests_Update;

import modules.service.RosterService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.update.roster.UpdateRosterBeforeMatchRequestBody;
import pojo.update.roster.UpdateRosterBeforeMatchResponse;
import util.DatabaseUtility;
import util.FileUtility;

import java.util.Properties;

public class UpdateRosterBeforeTossTest {
    RosterService rosterService;
    UpdateRosterBeforeMatchRequestBody.RosterData[] rosterDataArray;
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);

    @BeforeClass
    public void beforeClass() {
        rosterService = new RosterService();
        rosterDataArray = new UpdateRosterBeforeMatchRequestBody.RosterData[]{new UpdateRosterBeforeMatchRequestBody.RosterData(
                true,
                false,
                true,
                1,
                false,
                new UpdateRosterBeforeMatchRequestBody.User(
                        properties.getProperty("editMatchPlayer_1"),
                        properties.getProperty("editMatchPlayer_1") ,
                        "1"

                )
        ), new UpdateRosterBeforeMatchRequestBody.RosterData(
                true,
                false,
                false,
                1,
                false,
                new UpdateRosterBeforeMatchRequestBody.User(
                        properties.getProperty("editMatchPlayer_2"),
                        properties.getProperty("editMatchPlayer_2"),
                        "1"
                )
        ), new UpdateRosterBeforeMatchRequestBody.RosterData(
                true,
                false,
                false,
                1,
                false,
                new UpdateRosterBeforeMatchRequestBody.User(
                        properties.getProperty("editMatchPlayer_3"),
                        properties.getProperty("editMatchPlayer_3"),
                        "1"

                )
        ),
                  new UpdateRosterBeforeMatchRequestBody.RosterData(
                        true,
                        false,
                        false,
                        1,
                        false,
                    new UpdateRosterBeforeMatchRequestBody.User(
                            properties.getProperty("editMatchPlayer_4"),
                            properties.getProperty("editMatchPlayer_4"),
                                "1"

                        )
                )};
    }

    @Test
    public void shouldUpdateRosterBeforeToss() {
        UpdateRosterBeforeMatchRequestBody updateRosterBeforeMatchRequestBody = new UpdateRosterBeforeMatchRequestBody.Builder()
                .setMatchId(properties.getProperty("matchid_getplayeraccordingtogametype"))
                .setTeamId(properties.getProperty("teamid_getplayeraccordingtogametype"))
                .setRosterData(rosterDataArray)
                .build();
        UpdateRosterBeforeMatchResponse updateRosterBeforeMatchResponse = rosterService.updateRosterBeforeMatchService(updateRosterBeforeMatchRequestBody);
        updateRosterBeforeMatchResponse.assertUpdateRosterBeforeMatchResponse(updateRosterBeforeMatchRequestBody);

    }
}