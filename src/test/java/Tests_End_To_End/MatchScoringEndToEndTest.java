package Tests_End_To_End;

import lombok.Getter;
import lombok.Setter;
import modules.service.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.create.scoring.batsman.SetCurrentBatsmanRequestBody;
import pojo.create.scoring.batsman.SetCurrentBatsmanResponse;
import pojo.create.scoring.batsman.SetNewBatsMenRequestBody;
import pojo.create.scoring.batsman.SetNewBatsMenResponse;
import pojo.create.scoring.bowler.SetCurrentBowlerRequestBody;
import pojo.create.scoring.bowler.SetCurrentBowlerResponse;
import pojo.create.scoring.over.SetChangeMatchOverRequestBody;
import pojo.create.scoring.over.SetChangeMatchOverResponse;
import pojo.create.scoring.registerball.RegisterBallRequestBody;
import pojo.create.scoring.registerball.RegisterBallResponse;
import pojo.create.scoring.score.StartScoringResponse;
import pojo.create.scoring.toss.CreateTossRequestBody;
import pojo.create.scoring.toss.CreateTossResponse;
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
    String striker;
    String nonStriker;
    String bowler;
    String newBatsMan;


    @BeforeClass
    public void beforeClass() {
        matchesService = new MatchesService();
        teamsService = new TeamsService();
        scoringService = new ScoringService();
        rosterService = new RosterService();
        registerBallService = new RegisterBallService();

    }

    @Test
    public void tc_01_getMatchIdAndTeamId() {

       GetMyyMatchesResponse getMyyMatchesResponse = matchesService.getMyyMatchesUsingRole();
       List<GetMyyMatchesResponse.Data> dataList = getMyyMatchesResponse.getData();
        Optional<GetMyyMatchesResponse.Data> optionalMatch = dataList.stream()
               .filter(data -> data.getTeamOne().getShortName().equalsIgnoreCase("A11")&&data.getTeamTwo().getShortName().equalsIgnoreCase("MyT3")).findFirst();


        if (optionalMatch.isPresent()) {
            GetMyyMatchesResponse.Data match = optionalMatch.get();


            this.setMatch_id(match.getId());
            this.setTeam_one_id(match.getTeamOne().getId());
            this.setTeam_two_id(match.getTeamTwo().getId());

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
        GetPlaying11Response getPlaying11Response = rosterService.getPlayingBatsmen("64393e483215f73a9468c0e7");
       this.setStriker(getPlaying11Response.getData().get(0).getId());
        this.setNonStriker(getPlaying11Response.getData().get(1).getId());
        this.setNewBatsMan(getPlaying11Response.getData().get(2).getId());
        System.out.println("Striker is:"+ this.getStriker());
        System.out.println("non Striker is:"+ this.getNonStriker());
        System.out.println("new batsmen is:"+ this.getNewBatsMan());


        getPlaying11Response.assertPlaying11();
    }
    @Test
    public void  tc_04_setCurrentBatsmen()
    {
        SetCurrentBatsmanRequestBody setCurrentBatsmanRequestBody=new SetCurrentBatsmanRequestBody.Builder().setStriker(this.getStriker()).setNonStriker(this.getNonStriker()).build();
        SetCurrentBatsmanResponse setCurrentBatsmanResponse=new ScoringService().setCurrentBatsman(this.getMatch_id(),setCurrentBatsmanRequestBody);
        setCurrentBatsmanResponse.assertSetCurrentBatsmanResponse();
    }
    @Test
    public void tc_05_getBowlerFromRoster() {
        GetPlaying11Response getPlaying11Response = rosterService.getPlayingBowler(this.getMatch_id());
       this.setBowler(getPlaying11Response.getData().get(0).getId());
        System.out.println("Bowler is:"+ this.getBowler());
        getPlaying11Response.assertPlaying11();

    }
    @Test
    public void  tc_06_setCurrentBowler()
    {
        SetCurrentBowlerRequestBody setCurrentBowlerRequestBody=new SetCurrentBowlerRequestBody.Builder().setBowler(this.getBowler()).build();
        SetCurrentBowlerResponse setCurrentBowlerResponse=new ScoringService().setCurrentBowler(this.getMatch_id(),setCurrentBowlerRequestBody);
        setCurrentBowlerResponse.assertSetCurrentBowlerResponse();
    }

    @Test
    public void  tc_07_changeMatchOver()
    {
        SetChangeMatchOverRequestBody setChangeMatchOverRequestBody=new SetChangeMatchOverRequestBody.Builder().setBowler(this.getBowler()).build();
        SetChangeMatchOverResponse setChangeMatchOverResponse=new ScoringService().changeMatchOverService(this.getMatch_id(),setChangeMatchOverRequestBody);
        setChangeMatchOverResponse.assertSetChangeMatchOverResponse();
    }
    @Test
    public void  tc_08_startScoring()
    {
        StartScoringResponse startScoringResponse=new ScoringService().startScoringService("64393e483215f73a9468c0e7");
        startScoringResponse.assertStartScoringResponse();

    }
    @Test
    public void tc_09_ShouldGetCurrentMatchDetails() {

        GetLiveMatchDetailsResponse getLiveMatchDetailsResponse = matchesService.getCurrentMatchDetailsService("64393e483215f73a9468c0e7");
        getLiveMatchDetailsResponse.assertCurrentMatchDetails();
    }



    @Test
    public void tc_10_shouldRegisterBall() {

        int i = 1;
        while (i <= 6) {
            int runScored = i;
            int dismissalType = 0;
            int runtype = 0;
            if (runScored == 4) {
                runtype = 1;
            } else if (runScored ==3) {
                dismissalType = 1;
            } else if (runScored == 6) {
                runtype = 2;
            }
            System.out.println("My dismissal type:"+dismissalType);
            if (dismissalType == 0) {
                RegisterBallRequestBody registerBallRequestBody = new RegisterBallRequestBody.Builder()
                        .setRunScored(runScored)
                        .setRunType(runtype)
                        .setDismissalDetails(dismissalType)
                        .build();
                RegisterBallResponse registerBallResponse = scoringService.registerBall(this.getMatch_id(), registerBallRequestBody);
                System.out.println(" Striker is" + registerBallResponse.getData().getStriker().getId());
                System.out.println("Non Striker is" + registerBallResponse.getData().getNonStriker().getId());
                this.setNonStriker(registerBallResponse.getData().getNonStriker().getId());
                registerBallResponse.assertRegisterBallResponse(registerBallRequestBody);
                i++;
            } else if(dismissalType!=0){
                SetNewBatsMenRequestBody setNewBatsMenRequestBody = new SetNewBatsMenRequestBody.Builder().setStriker(this.getNewBatsMan()).setNonStriker(this.getNonStriker()).build();
                SetNewBatsMenResponse setNewBatsMenResponse = scoringService.ProcessDismissalService(this.getMatch_id(), setNewBatsMenRequestBody);
                setNewBatsMenResponse.assertSetNewBatsMenResponse();

                i++;

            }
        }
    }


}
