package pojo.create.post;

import lombok.Getter;
import lombok.Setter;
import util.FileUtility;

import java.util.Properties;

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
        public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
        public Properties properties= FileUtility.loadProperties(propertyPath);
        private String author;

        private String parentPost;

        private String resourceName;

        private String content;


        public Builder() {
            this.author =  properties.getProperty("author_id");
            this.parentPost = properties.getProperty("parentPost_id");
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
