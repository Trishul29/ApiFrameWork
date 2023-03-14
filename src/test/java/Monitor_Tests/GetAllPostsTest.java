package Monitor_Tests;

import Users.service.PostsService;
import pojo.getAll.posts.GetAllPostResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetAllPostsTest {
private PostsService postsService;

    @BeforeClass
    public void beforeClass()
    {

postsService=new PostsService();

    }

    @Test
    public void shouldGetAllPosts()
    {
        GetAllPostResponse getAllPostsResponse = postsService.getAllPost();
        assertEquals(getAllPostsResponse.getStatusCode(),200);
        assertEquals(getAllPostsResponse.getSuccess(),"true");


    }

}
