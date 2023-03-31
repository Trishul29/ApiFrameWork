package Tests_Monitor;

import modules.service.GoolePlaceService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.googleplace.GetGooglePlaceListResponse;

public class GetGooglePlaceListTest {
    GoolePlaceService goolePlaceService;
    @BeforeClass
    public void beforeClass()
    {
goolePlaceService=new GoolePlaceService();


    }
    @Test
    public void shouldGetPlaceList()
    {
GetGooglePlaceListResponse getGooglePlaceListResponse =goolePlaceService.getPlaceList();
getGooglePlaceListResponse.assertPlaceList();

    }
}
