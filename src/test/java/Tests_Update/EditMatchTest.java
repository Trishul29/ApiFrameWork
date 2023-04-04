package Tests_Update;

import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.update.match.EditMatchRequestBody;
import pojo.update.match.EditMatchResponse;

public class EditMatchTest {
   private EditMatchRequestBody.RosterDetails[] rosterDetails;
  //  private EditMatchRequestBody.RosterDetails[]rosterDetails1;
    MatchesService  matchesService;

    @BeforeMethod
    public void beforeClass()
    {
rosterDetails=new EditMatchRequestBody.RosterDetails[3];
rosterDetails[0]=new EditMatchRequestBody.RosterDetails(true,true,true,"62e114d5c905580636902b30");
rosterDetails[1]=new EditMatchRequestBody.RosterDetails(true,false,false,"62e114e2c905580636902b3b");
rosterDetails[2]=new EditMatchRequestBody.RosterDetails(true,true,false,"62e11503c905580636902b46");
matchesService=new MatchesService();

    }

    @Test
    public void shouldEditMatch()
    {

EditMatchRequestBody editMatchRequestBody=new  EditMatchRequestBody.Builder()

       .setMatchVenue(new EditMatchRequestBody.Address("ChIJL_P_CXMEDTkRw0ZdG-0GVvw","Delhi","India"),new EditMatchRequestBody.GroundName("","delhi"),"28.6862738","77.2217831")
        .setTeamOne("62e114c6c905580636902b26",false,rosterDetails)
        .setOfficialsId("","","6405df04f4e562a04fc85cee","640ec20d35ba5e3e6088b258","","")
        .build();
        EditMatchResponse editMatchResponse;
        editMatchResponse=matchesService.editMatchDetails(editMatchRequestBody);


        editMatchResponse.assertEditMatch(editMatchRequestBody);


    }
}
