package Tests_Monitor;
import modules.service.PostsService;
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
    @Step("{0}")
    public void shouldGetAllPosts()
    {//Filter: photos,videos
        GetAllPostResponse getAllPostsResponse = postsService.getAllPost("");
        getAllPostsResponse.assertGetAllPost();
    }

}
