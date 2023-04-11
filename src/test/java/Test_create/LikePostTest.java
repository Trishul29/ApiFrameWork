package Test_create;

import modules.service.PostsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.create.post.GiveLikeResponse;

public class LikePostTest
{
PostsService postsService;
    @BeforeClass
    public void beforeClass()
    {
        postsService=new PostsService();

    }
    @Test
    public void shouldLikeThePost()
    {
        GiveLikeResponse giveLikeResponse = postsService.giveLikeToPost();
        giveLikeResponse.assertGiveLikeResponse();

    }

}
