package Tests_Monitor;
import Users.service.PostsService;
import io.qameta.allure.Step;
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
    @Step
    public void shouldGetAllPosts()
    {
        GetAllPostResponse getAllPostsResponse = postsService.getAllPost();
        getAllPostsResponse.assertGetAllPost();
    }

}
