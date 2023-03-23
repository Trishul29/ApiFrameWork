package Test_create_request;
import modules.service.PostsService;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pojo.create.post.CreateReplyPostRequestBody;
import pojo.create.post.CreateReplyPostResponse;
public class CreateReplyPostTest {
    @Test
    @Step("perform createPost test")
    public void shouldCreateReplyPost()

    {
        CreateReplyPostRequestBody createReplyPostRequestBody = new CreateReplyPostRequestBody.Builder().build();
        CreateReplyPostResponse createReplyPostResponse = new PostsService().createReplyPost(createReplyPostRequestBody);
      createReplyPostResponse.assertCreateReplyPostDetails(createReplyPostRequestBody);
    }

}
