package pojo.create.post;
import lombok.Getter;
import lombok.Setter;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Getter
public class CreateReplyPostResponse {
    @Setter
    int statusCode;
    @Setter
    long responseTime;

    private String data;

    private String success;

    private String error;
    public void assertCreateReplyPostDetails(CreateReplyPostRequestBody createReplyPostRequestBody)
    {
        assertEquals(this.getSuccess(),"true");
        assertEquals(this.getStatusCode(),200);
        assertTrue(this.getResponseTime()<4);
        assertEquals(this.getData(),"Your post has been published successfully");
    }
}


