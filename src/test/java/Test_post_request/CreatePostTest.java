package Test_post_request;
import Users.service.PostsService;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pojo.create.post.CreatePostRequestBody;
import pojo.create.post.CreatePostResponse;
public class CreatePostTest {
    @Test
    @Step("perform createPost test")
    public void shouldCreatePost()

    {
        CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponse createPostResponse = new PostsService().createPost(createPostRequestBody);
       createPostResponse.assertCreatePostDetails(createPostRequestBody);
    }
}

