package Tests_Monitor;
import io.qameta.allure.Step;
import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.getAll.tournaments.GetTournamentsResponse;

public class GetTournamentsTest {
    private TournamentsService tournamentsService;
  //  private  String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
   // private Properties properties;

    @BeforeClass
    public void beforeClass()
    {
        tournamentsService=new TournamentsService();
    }
    @Test(description = "GetTournament Test For My Tournaments and All Tournaments")
    @Step("{0}")


    public void shouldGetTournamentTest()
    {

       GetTournamentsResponse getTournamentsResponse =tournamentsService.getTournaments("");

       getTournamentsResponse.assertGetAllTournamentsResponse();


    }
}
