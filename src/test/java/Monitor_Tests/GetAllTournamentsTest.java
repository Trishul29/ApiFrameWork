package Monitor_Tests;

import Users.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.tournaments.GetAllTournamentsResponse;
import util.FileUtility;

import java.util.Properties;

import static org.testng.Assert.*;

public class GetAllTournamentsTest {
    private TournamentsService tournamentsService;
    private  String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    private Properties properties;

    @BeforeClass
    public void beforeClass()
    {
        tournamentsService=new TournamentsService();
        properties = FileUtility.loadProperties(propertyPath);
    }
    @Test
    public void shouldGetAllTournamentTest()
    {
        //  String =properties.getProperty("teamid");

       GetAllTournamentsResponse getAllTournamentsResponse=tournamentsService.getAllTournaments();
        assertEquals(getAllTournamentsResponse.getStatusCode(),200,"Not able to get Recommended Users");
        assertEquals(getAllTournamentsResponse.getSuccess(),"true","Success Return False ");
        assertNotNull(getAllTournamentsResponse.getData().getDocs()[0].get_id(),"tournament not present");
        assertNotNull(getAllTournamentsResponse.getData().getDocs()[0].getGameType(),"Game type is not given");
        assertTrue(getAllTournamentsResponse.getResponseTime()<2,"Request taking more than 2 seconds");
        assertNotNull(getAllTournamentsResponse.getData().getDocs()[0].getName(),"Tournamnet name is not present");

    }
}
