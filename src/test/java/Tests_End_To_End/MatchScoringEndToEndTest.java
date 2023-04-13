package Tests_End_To_End;
import lombok.Getter;
import lombok.Setter;
import modules.service.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.create.match.RegisterBallRequestBody;
import pojo.create.match.RegisterBallResponse;
import pojo.create.scoring.CreateTossRequestBody;
import pojo.create.scoring.CreateTossResponse;
import pojo.get.Match.GetLiveMatchDetailsResponse;
import pojo.getAll.matches.GetMyyMatchesResponse;
import pojo.getAll.rosterdetaills.GetPlaying11Response;
import util.FileUtility;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Getter
@Setter
public class MatchScoringEndToEndTest {
    MatchesService matchesService;
    TeamsService teamsService;
    ScoringService scoringService;
    RosterService rosterService;
    RegisterBallService registerBallService;
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
        registerBallService=new RegisterBallService();

    }

    @Test
    public void tc_01_getMatchIdAndTeamId() {

        GetMyyMatchesResponse getMyyMatchesResponse = matchesService.getMyyMatchesUsingRole();
        List<GetMyyMatchesResponse.Data> dataList = getMyyMatchesResponse.getData();
        Optional<GetMyyMatchesResponse.Data> optionalMatch = dataList.stream()
                .filter(data -> data.getMatchStatus().getStatus().equals("pending")&& !(data.getMatchStatus().getReason() == null))//&& (data.getMatchStatus().getReason() == null)
                .findFirst();

        if (optionalMatch.isPresent()) {
            GetMyyMatchesResponse.Data match = optionalMatch.get();


//            this.setMatch_id(match.getId());
//            this.setTeam_one_id(match.getTeamOne().getId());
//            this.setTeam_two_id(match.getTeamTwo().getId());
            this.setMatch_id("6437fb9d254a2b7652804f35");
            this.setTeam_one_id("63345f3ea22c6c914e6476e9");
            this.setTeam_two_id("636e44d206e0c4c612e97dad");
            System.out.println("Match id is Hello:" + this.match_id);
            System.out.println("Team id1:" + this.getTeam_one_id());
            System.out.println("Team id2:" + this.getTeam_two_id());
        }


        getMyyMatchesResponse.assertMyyMatches();

    }


    @Test
    public void tc_02_createToss() {
        System.out.println("Match id is Hello:" + this.getMatch_id());
        CreateTossRequestBody createTossRequestBody = new CreateTossRequestBody.Builder().setCallingTeam(this.getTeam_one_id()).setBattingTeam(this.getTeam_one_id()).setBowlingTeam(this.getTeam_two_id()).build();
        CreateTossResponse createTossResponse = new ScoringService().createTossService(this.getMatch_id(), createTossRequestBody);
        createTossResponse.assertCreateTossResponse();
    }

    @Test
    public void tc_03_getBatsmenFromRoster() {
        GetPlaying11Response getPlaying11Response = rosterService.getPlayingBatsmen(this.getMatch_id());
        getPlaying11Response.assertPlaying11();
    }
    @Test
    public void tc_04_getBowlerFromRoster()
    {
        GetPlaying11Response getPlaying11Response = rosterService.getPlayingBowler(this.getMatch_id());
        getPlaying11Response.assertPlaying11();

    }

    @Test
    public void tc_04_ShouldgetCurrentMatchDetails()
    {

        GetLiveMatchDetailsResponse getLiveMatchDetailsResponse=matchesService.getCurrentMatchDetailsService(this.getMatch_id());
        getLiveMatchDetailsResponse.assertCurrentMatchDetails();
    }
    @Test
    public void  tc_05_shouldRegisterBall()
    {
        RegisterBallRequestBody registerBallRequestBody=new RegisterBallRequestBody.Builder().setRunScored(1).setRunType(0).setDismissalDetails(0).SetPitchMap(new RegisterBallRequestBody.Bounce(1024,1024),new RegisterBallRequestBody.Pitch(1024,1024)).setWagonWheel(200,1024,1024).build();
       RegisterBallResponse registerBallResponse= registerBallService.registerBall(this.getMatch_id(),registerBallRequestBody);
       registerBallResponse.assertRegisterBallResponse(registerBallRequestBody);
    }


}
