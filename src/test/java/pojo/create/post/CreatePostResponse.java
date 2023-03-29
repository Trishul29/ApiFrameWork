package pojo.create.post;
import lombok.Getter;
import lombok.Setter;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Getter
public class CreatePostResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;

    private String data;

    private String success;

    private String error;

    public void assertCreatePostDetails(CreatePostRequestBody createPostRequestBody)
    {

        assertEquals(this.getSuccess(),"true","Success Failure");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.getResponseTime()<=3000,"Response Taking More than 3 Seconds");
        assertEquals(this.getData(),"Your post has been published successfully");
    }

}
