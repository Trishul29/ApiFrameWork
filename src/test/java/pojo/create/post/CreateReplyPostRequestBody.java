package pojo.create.post;

import lombok.Getter;
@Getter
public class CreateReplyPostRequestBody {
    private String author;

  private String parentPost;

    private String resourceName;

    private String content;

    public  CreateReplyPostRequestBody(Builder builder)
    {
        this.author=builder.author;
        this.parentPost=builder.parentPost;
        this.resourceName=builder.resourceName;
        this.content=builder.content;
    }
    public static class Builder {

        private String author;

        private String parentPost;

        private String resourceName;

        private String content;


        public Builder() {
            this.author = "62e3a26140e6ba08298a7285";
            this.parentPost = "633410bcc3bd2c4771dc81fd";
            this.resourceName = "UserSports";
            this.content = "My User Post";
        }

        public CreateReplyPostRequestBody build( )
        {
            CreateReplyPostRequestBody createReplyPostRequestBody=new CreateReplyPostRequestBody(this);
            return createReplyPostRequestBody;
        }

    }
}
