package Tests_Update;

import modules.service.RosterService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.update.roster.UpdateRosterBeforeMatchRequestBody;
import pojo.update.roster.UpdateRosterBeforeMatchResponse;
import util.FileUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                        "642a848f8979bf55baf9b0fb",
                        "642a848f8979bf55baf9b0fb",
                        "1"

                )
        ), new UpdateRosterBeforeMatchRequestBody.RosterData(
                true,
                false,
                false,
                1,
                false,
                new UpdateRosterBeforeMatchRequestBody.User(
                        "632dd01cae18002d70e0ac97",
                        "632dd01cae18002d70e0ac97",
                        "1"
                )
        ), new UpdateRosterBeforeMatchRequestBody.RosterData(
                true,
                false,
                false,
                1,
                false,
                new UpdateRosterBeforeMatchRequestBody.User(
                        "632ab363f6519b0179d00520",
                        "632ab363f6519b0179d00520",
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
                                "632858599f934f7b1359ddd2",
                                "632858599f934f7b1359ddd2",
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