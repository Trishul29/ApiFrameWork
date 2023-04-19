package Tests_Update;

import modules.service.RosterService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.update.roster.UpdateRosterBeforeMatchRequestBody;
import pojo.update.roster.UpdateRosterBeforeMatchResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateRosterBeforeTossTest {
    RosterService rosterService;
    UpdateRosterBeforeMatchRequestBody.RosterData[] rosterDataArray;
   // UpdateRosterBeforeMatchRequestBody obj = new UpdateRosterBeforeMatchRequestBody();

    @BeforeClass
    public void beforeClass() {
        rosterService = new RosterService();
//        List<UpdateRosterBeforeMatchRequestBody.RosterData> data = new ArrayList<>();
//
//        UpdateRosterBeforeMatchRequestBody.User user_1 = new UpdateRosterBeforeMatchRequestBody.User(
//                "",
//                "",
//                "",
//                "",
//                new UpdateRosterBeforeMatchRequestBody.Location(""),
//                "",
//                "",
//                "",
//                "",
//                ""
//        );
//        UpdateRosterBeforeMatchRequestBody.User user_2 = new UpdateRosterBeforeMatchRequestBody.User(
//                "",
//                "",
//                "",
//                "",
//                new UpdateRosterBeforeMatchRequestBody.Location(""),
//                "",
//                "",
//                "",
//                "",
//                ""
//        );
//        UpdateRosterBeforeMatchRequestBody.User user_3 = new UpdateRosterBeforeMatchRequestBody.User(
//                "",
//                "",
//                "",
//                "",
//                new UpdateRosterBeforeMatchRequestBody.Location(""),
//                "",
//                "",
//                "",
//                "",
//                ""
//        );
//        UpdateRosterBeforeMatchRequestBody.User user_3 = new UpdateRosterBeforeMatchRequestBody.User(
//                "",
//                "",
//                "",
//                "",
//                new UpdateRosterBeforeMatchRequestBody.Location(""),
//                "",
//                "",
//                "",
//                "",
//                ""
//        );
//        UpdateRosterBeforeMatchRequestBody.User user_4 = new UpdateRosterBeforeMatchRequestBody.User(
//                "",
//                "",
//                "",
//                "",
//                new UpdateRosterBeforeMatchRequestBody.Location(""),
//                "",
//                "",
//                "",
//                "",
//                ""
//        );
//        UpdateRosterBeforeMatchRequestBody.User user_5 = new UpdateRosterBeforeMatchRequestBody.User(
//                "",
//                "",
//                "",
//                "",
//                new UpdateRosterBeforeMatchRequestBody.Location(""),
//                "",
//                "",
//                "",
//                "",
//                ""
//        );
//
//        UpdateRosterBeforeMatchRequestBody.User[] userList = obj.settingUserData(user_1, user_2, user_3, user_4, user_5);
//
//        for (int i = 0; i < 6; i++) {
//            UpdateRosterBeforeMatchRequestBody.RosterData roster = new UpdateRosterBeforeMatchRequestBody.RosterData(
//                    true,
//                    false,
//                    true,
//                    1,
//                    false,
//                    userList[i]
//            );
//            data.add(roster);
//        }
//        rosterDataArray = obj.settingRosterData(data);
        rosterDataArray = new UpdateRosterBeforeMatchRequestBody.RosterData[]{new UpdateRosterBeforeMatchRequestBody.RosterData(
                true,
                false,
                true,
                1,
                false,
                new UpdateRosterBeforeMatchRequestBody.User(
                        "Shiva",
                        "",
                        true,
                        "",
                        new UpdateRosterBeforeMatchRequestBody.Location(""),
                        "",
                        "6322e05bd84497d62f9eeee9",
                        "6322e05bd84497d62f9eeee9",
                        "",
                        ""
                )
        ), new UpdateRosterBeforeMatchRequestBody.RosterData(
                true,
                false,
                false,
                1,
                false,
                new UpdateRosterBeforeMatchRequestBody.User(
                        "",
                        "",
                        true,
                        "",
                        new UpdateRosterBeforeMatchRequestBody.Location(""),
                        "",
                        "",
                        "",
                        "",
                        ""
                )
        ), new UpdateRosterBeforeMatchRequestBody.RosterData(
                true,
                false,
                false,
                1,
                false,
                new UpdateRosterBeforeMatchRequestBody.User(
                        "",
                        "",
                        false,
                        "",
                        new UpdateRosterBeforeMatchRequestBody.Location(""),
                        "",
                        "",
                        "",
                        "",
                        ""
                )
        ),
                  new UpdateRosterBeforeMatchRequestBody.RosterData(
                        true,
                        false,
                        false,
                        1,
                        false,
                    new UpdateRosterBeforeMatchRequestBody.User(
                                "",
                                "",
                                false,
                                "",
                    new UpdateRosterBeforeMatchRequestBody.Location(""),
                                "",
                                "",
                                "",
                                "",
                                ""
                        )
                )};
    }

    @Test
    public void shouldUpdateRosterBeforeToss() {
        UpdateRosterBeforeMatchRequestBody updateRosterBeforeMatchRequestBody = new UpdateRosterBeforeMatchRequestBody.Builder()
                .setMatchId("643fd84bfbf49862d9a39ae2")
                .setTeamId("643e6a92eb1d6ea1587e43c7")
                .setRosterData(rosterDataArray)
                .build();
        UpdateRosterBeforeMatchResponse updateRosterBeforeMatchResponse = rosterService.updateRosterBeforeMatchService(updateRosterBeforeMatchRequestBody);
        updateRosterBeforeMatchResponse.assertUpdateRosterBeforeMatchResponse(updateRosterBeforeMatchRequestBody);

    }
}