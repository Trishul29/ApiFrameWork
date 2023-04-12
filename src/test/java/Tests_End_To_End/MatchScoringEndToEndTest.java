package Tests_End_To_End;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import modules.service.MatchesService;
import modules.service.RosterService;
import modules.service.ScoringService;
import modules.service.TeamsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.create.scoring.CreateTossRequestBody;
import pojo.create.scoring.CreateTossResponse;
import pojo.getAll.matches.GetMyyMatchesResponse;
import pojo.getAll.rosterdetaills.GetPlaying11BatsmenResponse;
import util.FileUtility;

import java.util.List;
import java.util.Properties;

@Getter
@Setter
public class MatchScoringEndToEndTest {
    MatchesService matchesService;
    TeamsService teamsService;
    ScoringService scoringService;
    RosterService rosterService;
    public String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties = FileUtility.loadProperties(propertyPath);
    String scorer_id = properties.getProperty("scorer_id");
    String manager_id = properties.getProperty("manager_id");
    String streamer_id = properties.getProperty("streamer_id");
    String team_one_id;
    String team_two_id;
    String match_id = "";


    @BeforeClass
    public void beforeClass() {
        matchesService = new MatchesService();
        teamsService = new TeamsService();
        scoringService = new ScoringService();
        rosterService = new RosterService();

    }

    @Test
    public void tc_01_getMatchIdAndTeamId() {

        GetMyyMatchesResponse getMyyMatchesResponse = matchesService.getMyyMatchesUsingRole();
        List<GetMyyMatchesResponse.Data> dataList = getMyyMatchesResponse.getData();
        for (GetMyyMatchesResponse.Data data : dataList) {
            int no_of_matches = dataList.size();
            int order = Faker.instance().number().numberBetween(1, no_of_matches);
            String s = dataList.get(order).getMatchStatus().getStatus();
            //if (dataList.get(order).getMatchStatus().getStatus().equals("pending")&&!(dataList.get(order).getMatchStatus().getReason().equals("Toss occurred")))
                if (dataList.get(order).getMatchStatus().getStatus().equals("pending"))
                {
                this.setMatch_id(dataList.get(order).getId());
                this.setTeam_one_id(dataList.get(order).getTeamOne().getId());
                this.setTeam_two_id(dataList.get(order).getTeamTwo().getId());
//                System.out.println("Match id is Hello:" + this.match_id);
//                System.out.println("Team id1:"+this.getTeam_one_id());
//                System.out.println("Team id2:"+this.getTeam_two_id());
            }
        }

        getMyyMatchesResponse.assertMyyMatches();
    }



    @Test
    public void tc_03_createToss() {
        System.out.println("Match id is Hello:" + this.getMatch_id());
        CreateTossRequestBody createTossRequestBody = new CreateTossRequestBody.Builder().setCallingTeam(this.getTeam_one_id()).setBattingTeam(this.getTeam_one_id()).setBowlingTeam(this.getTeam_two_id()).build();
        CreateTossResponse createTossResponse = new ScoringService().createTossService(this.getMatch_id(), createTossRequestBody);
        createTossResponse.assertCreateTossResponse();
    }

    @Test
    public void tc_04_getBatsmenFromRoster() {
        GetPlaying11BatsmenResponse getPlaying11BatsmenResponse = rosterService.getPlayingBatsmen(this.getMatch_id());
        getPlaying11BatsmenResponse.assertBatsmenPlaying11();
    }

}
