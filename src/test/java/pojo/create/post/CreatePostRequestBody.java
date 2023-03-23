package pojo.create.post;
import lombok.Getter;

@Getter
public class CreatePostRequestBody {
    private String author;
    private String resourceName;
    private String content;

    public  CreatePostRequestBody(Builder builder)
    {
       this.author=builder.author;
       this.resourceName=builder.resourceName;
       this.content=builder.content;
    }
     public static class Builder {

         private String author;
         private String resourceName;
         private String content;


         public Builder() {
             this.author = "62ef54b4fd4b8b60d8aa0279";
             this.resourceName = "UserSports";
             this.content = "Create text Post";
         }

         public CreatePostRequestBody build( )
         {
             CreatePostRequestBody createPostRequestBody=new CreatePostRequestBody(this);
             return createPostRequestBody;
         }

     }

}
