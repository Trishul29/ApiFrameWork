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
            this.author = "641d1ab94d6d31dc71601b12";
            this.parentPost = "6421767e4d6d31dc71614b0b";
            this.resourceName = "UserSports";
            this.content = "My User reply Post";
        }

        public CreateReplyPostRequestBody build( )
        {
            CreateReplyPostRequestBody createReplyPostRequestBody=new CreateReplyPostRequestBody(this);
            return createReplyPostRequestBody;
        }

    }
}
