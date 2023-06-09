package Test_create;
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
        //ResourceName:Tournament,Team,Show
        CreateReplyPostRequestBody createReplyPostRequestBody = new CreateReplyPostRequestBody.Builder().setResourceName("Show").build();
        CreateReplyPostResponse createReplyPostResponse = new PostsService().createReplyPost(createReplyPostRequestBody);
      createReplyPostResponse.assertCreateReplyPostDetails(createReplyPostRequestBody);
    }

}
