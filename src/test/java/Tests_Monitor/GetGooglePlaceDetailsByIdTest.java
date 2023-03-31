package Tests_Monitor;

import modules.service.GoolePlaceService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.googleplace.GetGooglePlaceDetailsResponse;

public class GetGooglePlaceDetailsByIdTest {
    GoolePlaceService goolePlaceService;
    @BeforeClass
    public void beforeClass()
    {
        goolePlaceService=new GoolePlaceService();
    }
    @Test
    public void ShouldGetGooglePlaceDetails()
    {
     GetGooglePlaceDetailsResponse googlePlaceDetailsResponse =goolePlaceService.getPlaceDetails();
     googlePlaceDetailsResponse.assertPlaceDetails();
    }
}
