package Test_create;
import modules.service.PostsService;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pojo.create.post.CreatePostRequestBody;
import pojo.create.post.CreatePostResponse;
public class CreatePostTest {
    @Test
    @Step("perform createPost test")
    public void shouldCreatePost()

    {
        //Resource=Tournament,Show,Team
        CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody.Builder().setResourceName("Tournament").build();
        CreatePostResponse createPostResponse = new PostsService().createPost(createPostRequestBody);
       createPostResponse.assertCreatePostDetails(createPostRequestBody);
    }
}

