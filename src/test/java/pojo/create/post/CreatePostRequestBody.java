package pojo.create.post;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
public class CreatePostRequestBody {
    private String author;
    private String resourceName;
    private String content;
    private String[] videos;

    public  CreatePostRequestBody(Builder builder)
    {
       this.author=builder.author;
       this.resourceName=builder.resourceName;
       this.content=builder.content;
       this.videos=builder.videos;
    }
     public static class Builder {

         private String author;

         private String resourceName;
         private String content;
         private String[] videos;


         public Builder() {
             this.author = "62ef54b4fd4b8b60d8aa0279";
             this.videos=new String[]{"637c7e01238d5418d989f75d"};
             this.content = Faker.instance(new Locale("en_IND")).esports().game();
         }
         public  Builder setResourceName(String resourceName)
         {
             this.resourceName=resourceName;
             return this;
         }

         public CreatePostRequestBody build( )
         {
             CreatePostRequestBody createPostRequestBody=new CreatePostRequestBody(this);
             return createPostRequestBody;
         }

     }

}
