package Tests_End_To_End;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import modules.service.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;
import pojo.create.scoring.batsman.SetCurrentBatsmanRequestBody;
import pojo.create.scoring.batsman.SetCurrentBatsmanResponse;
import pojo.create.scoring.batsman.SetNewBatsMenRequestBody;
import pojo.create.scoring.batsman.SetNewBatsMenResponse;
import pojo.create.scoring.bowler.SetCurrentBowlerRequestBody;
import pojo.create.scoring.bowler.SetCurrentBowlerResponse;
import pojo.create.scoring.endinning.EndInningRequestBody;
import pojo.create.scoring.endinning.EndInningResponse;
import pojo.create.scoring.over.SetChangeMatchOverRequestBody;
import pojo.create.scoring.over.SetChangeMatchOverResponse;
import pojo.create.scoring.registerball.RegisterBallRequestBody;
import pojo.create.scoring.registerball.RegisterBallResponse;
import pojo.create.scoring.score.StartScoringResponse;
import pojo.create.scoring.secondinning.StartSecondInningRequestBody;
import pojo.create.scoring.secondinning.StartSecondInningResponse;
import pojo.create.scoring.toss.CreateTossRequestBody;
import pojo.create.scoring.toss.CreateTossResponse;
import pojo.get.Match.GetLiveMatchDetailsResponse;
import pojo.getAll.globalsearch.GetGlobalSearchResponse;
import pojo.getAll.matches.GetMyyMatchesResponse;
import pojo.getAll.rosterdetaills.GetPlaying11Response;
import util.FileUtility;

import java.util.*;

@Getter
@Setter
public class MatchScoringEndToEndTest {
    public String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties = FileUtility.loadProperties(propertyPath);

    SearchService searchService;
    MatchesService matchesService;
    TeamsService teamsService;
    ScoringService scoringService;
    RosterService rosterService;
    RegisterBallService registerBallService;

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
    String nextBowler;
    String team_One;
    String team_Two;

    CreateMatchRequestBody.RosterDetails[] rosterDetails;
    CreateMatchRequestBody.RosterDetails[] rosterDetails1;


    @BeforeTest
    public void beforeClass() {
        searchService = new SearchService();
        matchesService = new MatchesService();
        teamsService = new TeamsService();
        scoringService = new ScoringService();
        rosterService = new RosterService();
        registerBallService = new RegisterBallService();


    }

    @BeforeClass
    public void setPlayers() {
        String team_name_1 = "RAX  Mumbai Indians";
        String team_name_2 = "RAX  Punjab Kings";
        //int count = 0;
        GetGlobalSearchResponse getGlobalSearchResponse = searchService.getSearchByKeyword();
        for (GetGlobalSearchResponse.Data data : getGlobalSearchResponse.getData()) {
            if (data.getType().equalsIgnoreCase("Team")) {
                for (GetGlobalSearchResponse.Value value : data.getValue()) {
                    if (value.getName().equalsIgnoreCase(team_name_1)) {
                        System.out.println("name bolte" + value.getName());
                        setTeam_one_id(value.getId());
                    } else if (value.getName().equalsIgnoreCase(team_name_2)) {
                        setTeam_two_id(value.getId());
                    }
                }
                System.out.println("team one is:" + this.getTeam_one_id());
                System.out.println("team two is:" + getTeam_two_id());
            }
        }


        rosterDetails = new CreateMatchRequestBody.RosterDetails[5];
        rosterDetails[0] = new CreateMatchRequestBody.RosterDetails(true, true, false, "63e1e87967ba4538fe6ce781");
        rosterDetails[1] = new CreateMatchRequestBody.RosterDetails(false, false, false, "63abee254bcab7a88a1327d6");
        rosterDetails[2] = new CreateMatchRequestBody.RosterDetails(false, false, false, "6332e8197923eb6c8f7d3227");
        rosterDetails[3] = new CreateMatchRequestBody.RosterDetails(false, false, false, "6324886fa80dbc05defc8086");
        rosterDetails[4] = new CreateMatchRequestBody.RosterDetails(false, false, false, "6332c52f7923eb6c8f7d2112");

        rosterDetails1 = new CreateMatchRequestBody.RosterDetails[5];
        rosterDetails1[0] = new CreateMatchRequestBody.RosterDetails(false, true, false, "632dd01cae18002d70e0ac97");
        rosterDetails1[1] = new CreateMatchRequestBody.RosterDetails(false, false, false, "642a848f8979bf55baf9b0fb");
        rosterDetails1[2] = new CreateMatchRequestBody.RosterDetails(false, false, false, "632ab363f6519b0179d00520");
        rosterDetails1[3] = new CreateMatchRequestBody.RosterDetails(false, false, false, "632858599f934f7b1359ddd2");
        rosterDetails1[4] = new CreateMatchRequestBody.RosterDetails(true, false, false, "6322e05bd84497d62f9eeee9");

    }


    @Test
    public void tc_00_createMatchTest() {

        CreateMatchRequestBody createMatchRequestBody = new CreateMatchRequestBody.Builder().setManager(new String[]{properties.getProperty("manager_id")})
                .setMatchVenue(new CreateMatchRequestBody.Address(Faker.instance().regexify("[A-Z0-9_-]{12}"), Faker.instance(new Locale("en_IND")).address().city(), Faker.instance(new Locale("en_IND")).address().country()), new CreateMatchRequestBody.GroundName(Faker.instance().regexify("[A-Z0-9_-]{20}"), Faker.instance(new Locale("en_IND")).country().name()), "28.6862738", "77.2217831")
                .setOfficialsId(properties.getProperty("umpire_id"), properties.getProperty("umpire_id"), properties.getProperty("scorer_id"), "", "", properties.getProperty("streamer_id"))
                .setTeamOne(getTeam_one_id(), false, rosterDetails)
                .setTeamTwo(getTeam_two_id(), false, rosterDetails1)
                .build();

        CreateMatchResponse createMatchResponse = new MatchesService().createMatch(createMatchRequestBody);
        //Setting Match Id
        setMatch_id(createMatchResponse.getData().getMatchId());
        createMatchResponse.assertMatchDetails(createMatchRequestBody);
    }

    @Test(enabled = false)
    public void tc_01_getMatchIdAndTeamId() {

        GetMyyMatchesResponse getMyyMatchesResponse = matchesService.getMyyMatchesUsingRole();
        List<GetMyyMatchesResponse.Data> dataList = getMyyMatchesResponse.getData();
        Optional<GetMyyMatchesResponse.Data> optionalMatch = dataList.stream().filter(data -> data.getTeamOne().getShortName().equalsIgnoreCase("TEAM") && data.getTeamTwo().getShortName().equalsIgnoreCase("TLP")).findFirst();


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
        GetPlaying11Response getPlaying11Response = rosterService.getPlayingBatsmen(getMatch_id());
        int playingBatsman = getPlaying11Response.getData().size();
        int i = 2;
        while (i != playingBatsman) {
            this.setNewBatsMan(getPlaying11Response.getData().get(i).getId());
            i++;
        }
        this.setStriker(getPlaying11Response.getData().get(0).getId());
        this.setNonStriker(getPlaying11Response.getData().get(1).getId());
        //  this.setNewBatsMan(getPlaying11Response.getData().get(2).getId());
        System.out.println("Striker is:" + this.getStriker());
        System.out.println("non Striker is:" + this.getNonStriker());
        System.out.println("new batsmen is:" + this.getNewBatsMan());


        getPlaying11Response.assertPlaying11();
    }

    @Test
    public void tc_04_setCurrentBatsmen() {
        SetCurrentBatsmanRequestBody setCurrentBatsmanRequestBody = new SetCurrentBatsmanRequestBody.Builder().setStriker(this.getStriker()).setNonStriker(this.getNonStriker()).build();
        SetCurrentBatsmanResponse setCurrentBatsmanResponse = new ScoringService().setCurrentBatsman(this.getMatch_id(), setCurrentBatsmanRequestBody);
        setCurrentBatsmanResponse.assertSetCurrentBatsmanResponse();
    }

    @Test
    public void tc_05_getBowlerFromRoster() {
        GetPlaying11Response getPlaying11Response = rosterService.getPlayingBowler(this.getMatch_id());
        this.setBowler(getPlaying11Response.getData().get(0).getId());
        this.setNextBowler(getPlaying11Response.getData().get(1).getId());
        System.out.println("Bowler is:" + this.getBowler());
        getPlaying11Response.assertPlaying11();

    }

    @Test
    public void tc_06_setCurrentBowler() {
        SetCurrentBowlerRequestBody setCurrentBowlerRequestBody = new SetCurrentBowlerRequestBody.Builder().setBowler(this.getBowler()).build();
        SetCurrentBowlerResponse setCurrentBowlerResponse = new ScoringService().setCurrentBowler(this.getMatch_id(), setCurrentBowlerRequestBody);
        setCurrentBowlerResponse.assertSetCurrentBowlerResponse();
    }

    @Test
    public void tc_07_changeMatchOver() {
        SetChangeMatchOverRequestBody setChangeMatchOverRequestBody = new SetChangeMatchOverRequestBody.Builder().setBowler(this.getBowler()).build();
        SetChangeMatchOverResponse setChangeMatchOverResponse = new ScoringService().changeMatchOverService(this.getMatch_id(), setChangeMatchOverRequestBody);
        setChangeMatchOverResponse.assertSetChangeMatchOverResponse();
    }

    @Test
    public void tc_08_startScoring() {
        StartScoringResponse startScoringResponse = new ScoringService().startScoringService(getMatch_id());
        startScoringResponse.assertStartScoringResponse();

    }

    @Test
    public void tc_09_ShouldGetCurrentMatchDetails() {

        GetLiveMatchDetailsResponse getLiveMatchDetailsResponse = matchesService.getCurrentMatchDetailsService(getMatch_id());
        getLiveMatchDetailsResponse.assertCurrentMatchDetails();
    }


    @Test
    public void tc_10_shouldRegisterBall_FirstInning() {
        int i = 1;
        while (i <= 6) {
            int runScored = Faker.instance().number().numberBetween(1, 6);
            System.out.println("faker ke run" + runScored);
            int dismissalType = 0;
            int runtype = 0;
            if (runScored == 4) {
                runtype = 1;
            } else if (runScored == 6) {
                runtype = 2;
            }
            System.out.println("My dismissal type:" + dismissalType);
            {
                RegisterBallRequestBody registerBallRequestBody = new RegisterBallRequestBody.Builder().setRunScored(runScored).setRunType(runtype).setDismissalDetails(dismissalType).build();
                RegisterBallResponse registerBallResponse = scoringService.registerBall(this.getMatch_id(), registerBallRequestBody);

                registerBallResponse.assertRegisterBallResponse(registerBallRequestBody);
                if (i == 6) {
                    this.setStriker(registerBallResponse.getData().getStriker().getId());
                    this.setNonStriker(registerBallResponse.getData().getNonStriker().getId());
                    System.out.println(" Striker is" + this.getStriker());
                    System.out.println("Non Striker is" + this.getNonStriker());
                }
                i++;
            }
        }
    }

    @Test
    public void tc_11_changeOver() {
        SetCurrentBowlerRequestBody setCurrentBowlerRequestBody = new SetCurrentBowlerRequestBody.Builder().setBowler(this.getNextBowler()).build();
        SetCurrentBowlerResponse setCurrentBowlerResponse = new ScoringService().setCurrentBowler(this.getMatch_id(), setCurrentBowlerRequestBody);
        SetChangeMatchOverRequestBody setChangeMatchOverRequestBody = new SetChangeMatchOverRequestBody.Builder().setBowler(this.getNextBowler()).build();
        SetChangeMatchOverResponse setChangeMatchOverResponse = new ScoringService().changeMatchOverService(this.getMatch_id(), setChangeMatchOverRequestBody);
        setCurrentBowlerResponse.assertSetCurrentBowlerResponse();
        setChangeMatchOverResponse.assertSetChangeMatchOverResponse();
    }

    @Test
    public void tc_12_shouldProcessDismissal() {
        RegisterBallRequestBody registerBallRequestBody = new RegisterBallRequestBody.Builder().setRunScored(0).setRunType(0).setDismissalDetails(1).build();
        System.out.println("match id dede:" + getMatch_id());
        RegisterBallResponse registerBallResponse = scoringService.registerBall(getMatch_id(), registerBallRequestBody);
        SetNewBatsMenRequestBody setNewBatsMenRequestBody = new SetNewBatsMenRequestBody.Builder().setStriker(this.getNewBatsMan()).setNonStriker(this.getNonStriker()).build();
        SetNewBatsMenResponse setNewBatsMenResponse = scoringService.ProcessDismissalService(getMatch_id(), setNewBatsMenRequestBody);
        setNewBatsMenResponse.assertSetNewBatsMenResponse();
    }

    @Test
    public void tc_13_shouldEndInning() {
        EndInningRequestBody endInningRequestBody = new EndInningRequestBody.Builder().build();
        EndInningResponse endInningResponse = scoringService.endInningService(getMatch_id(), endInningRequestBody);
        endInningResponse.assertEndInning(endInningRequestBody);
    }

    @Test
    public void tc_14_shouldStartSecondInning() {
        StartSecondInningRequestBody startSecondInningRequestBody = new StartSecondInningRequestBody.Builder().build();
        StartSecondInningResponse startSecondInningResponse = scoringService.ChangeInningService(getMatch_id(), startSecondInningRequestBody);
        startSecondInningResponse.assertSecondInning(startSecondInningRequestBody);
    }

    @Test
    public void tc_15_scoreSecondInning() {
//Get Stiker ,non striker
        GetPlaying11Response getPlaying11Response = rosterService.getPlayingBatsmen(getMatch_id());
        int playingBatsman = getPlaying11Response.getData().size();
        int i = 2;
        while (i != playingBatsman) {
            this.setNewBatsMan(getPlaying11Response.getData().get(i).getId());
            i++;
        }
        this.setStriker(getPlaying11Response.getData().get(0).getId());
        this.setNonStriker(getPlaying11Response.getData().get(1).getId());
        System.out.println("Striker is:" + this.getStriker());
        System.out.println("non Striker is:" + this.getNonStriker());
        System.out.println("new batsmen is:" + this.getNewBatsMan());
        //set striker,non striker
        SetCurrentBatsmanRequestBody setCurrentBatsmanRequestBody = new SetCurrentBatsmanRequestBody.Builder().setStriker(this.getStriker()).setNonStriker(this.getNonStriker()).build();
        SetCurrentBatsmanResponse setCurrentBatsmanResponse = new ScoringService().setCurrentBatsman(getMatch_id(), setCurrentBatsmanRequestBody);

        //Get bowler from roaster
        getPlaying11Response = rosterService.getPlayingBowler(getMatch_id());
        this.setBowler(getPlaying11Response.getData().get(0).getId());
        //set current bowler

        SetCurrentBowlerRequestBody setCurrentBowlerRequestBody = new SetCurrentBowlerRequestBody.Builder().setBowler(this.getBowler()).build();
        SetCurrentBowlerResponse setCurrentBowlerResponse = new ScoringService().setCurrentBowler(getMatch_id(), setCurrentBowlerRequestBody);

        //Changematch over
        SetChangeMatchOverRequestBody setChangeMatchOverRequestBody = new SetChangeMatchOverRequestBody.Builder().setBowler(this.getBowler()).build();
        SetChangeMatchOverResponse setChangeMatchOverResponse = new ScoringService().changeMatchOverService(getMatch_id(), setChangeMatchOverRequestBody);

        //start scoring
        StartScoringResponse startScoringResponse = new ScoringService().startScoringService(getMatch_id());

        //register ball second inning
        int ballNo = 1;
        int runScored = 6;
        int runtype = 2;
        int dismissalType = 0;

        while (ballNo != 5) {
            RegisterBallRequestBody registerBallRequestBody = new RegisterBallRequestBody.Builder().setRunScored(runScored).setRunType(runtype).setDismissalDetails(dismissalType).build();
            RegisterBallResponse registerBallResponse = scoringService.registerBall(getMatch_id(), registerBallRequestBody);
            registerBallResponse.assertRegisterBallResponse(registerBallRequestBody);
            ballNo++;

        }

    }
}
