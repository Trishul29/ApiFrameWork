package Tests_Monitor;

import modules.service.PostsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.posts.GetShowListResponse;

public class GetAllShowsListTest {
    PostsService postsService;
    @BeforeClass
    public void beforeClass()
    {
postsService=new PostsService();

    }
    @Test
    public void shouldGetListOfShows()
    {
        GetShowListResponse getShowListResponse = postsService.getShowList();
        getShowListResponse.assertGetShowList();

    }
}
