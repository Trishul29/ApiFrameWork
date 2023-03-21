package pojo.create.post;
import lombok.Getter;

@Getter
public class CreatePostRequestBody {
    private String author;

    private String[] videos;

    private String resourceName;

    private String content;

    public  CreatePostRequestBody(Builder builder)
    {
       this.author=builder.author;
       this.videos=builder.videos;
       this.resourceName=builder.resourceName;
       this.content=builder.content;
    }
     public static class Builder {

         private String author;

         private String[] videos;

         private String resourceName;

         private String content;


         public Builder() {
             this.author = "638dae441c510a380ca38967";
             this.videos = new String[]{"637c7e01238d5418d989f75d"};
             this.resourceName = "UserSports";
             this.content = "My User Post";
         }

         public CreatePostRequestBody build( )
         {
             CreatePostRequestBody createPostRequestBody=new CreatePostRequestBody(this);
             return createPostRequestBody;
         }

     }

}
