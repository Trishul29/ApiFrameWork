package Tests_Monitor;
import io.qameta.allure.Step;
import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.tournaments.GetAllTournamentsResponse;
import java.util.Properties;

public class GetAllTournamentsTest {
    private TournamentsService tournamentsService;
  //  private  String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
   // private Properties properties;

    @BeforeClass
    public void beforeClass()
    {
        tournamentsService=new TournamentsService();
      //  properties = FileUtility.loadProperties(propertyPath);
    }
    @Test
    @Step("{0}")

    public void shouldGetAllTournamentTest()
    {

       GetAllTournamentsResponse getAllTournamentsResponse=tournamentsService.getAllTournaments();

       getAllTournamentsResponse.assertGetAllTournamentsResponse();


    }
}
