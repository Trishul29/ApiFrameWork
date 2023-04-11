package pojo.create.post;

import lombok.Getter;
import lombok.Setter;

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
            this.author = "622ce6ad9b5e5ee6c1ebe468";
            this.parentPost = "63328fa076da953898166b49";
            this.resourceName = "UserSports";
            this.content = "My User reply Post";
        }
        public Builder setResourceName(String resourceName)
        {
            this.resourceName=resourceName;
            return this;
        }

        public CreateReplyPostRequestBody build( )
        {
            CreateReplyPostRequestBody createReplyPostRequestBody=new CreateReplyPostRequestBody(this);
            return createReplyPostRequestBody;
        }

    }
}
