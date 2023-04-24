package pojo.create.post;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import util.FileUtility;

import java.util.Locale;
import java.util.Properties;

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
         public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
         public Properties properties= FileUtility.loadProperties(propertyPath);

         private String author;

         private String resourceName;
         private String content;
         private String[] videos;


         public Builder() {
             this.author = properties.getProperty("author_id");
             this.videos=new String[]{properties.getProperty("videosId")};
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
