package Tests_Monitor;

import modules.service.CommentaryService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Match.GetMatchCommentaryResponse;

public class GetMatchCommentaryTest {
    CommentaryService commentaryService;
    @BeforeClass
    public void beforeClass()
    {
        commentaryService=new CommentaryService();
    }
    @Test
    public void shouldGetMatchCommentary()
    {

        GetMatchCommentaryResponse getMatchCommentaryResponse= new CommentaryService().getMatchCommentary();
        getMatchCommentaryResponse.assertCommentaryDetails();
    }
}
