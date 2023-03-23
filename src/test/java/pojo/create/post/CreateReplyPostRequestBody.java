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
            this.author = "63233ba5dcd2d913bf2a9b83";
            this.parentPost = "641c059e8a216dafd130be3c";
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
