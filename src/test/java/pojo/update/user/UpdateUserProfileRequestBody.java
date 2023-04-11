package pojo.update.user;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.Locale;


@Getter
public class UpdateUserProfileRequestBody {
    private String email;
    private String firstName;
    private String lastName;
    private String location;

    public UpdateUserProfileRequestBody(Builder builder) {
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.location = builder.location;
    }
    public static class Builder{
        private String email;
        private String firstName;
        private String lastName;
        private String location;

        public  Builder()
        {
            this.email= Faker.instance(new Locale("en_IND")).internet().emailAddress();
            this.firstName=Faker.instance(new Locale("en_IND")).name().firstName();
            this.lastName=Faker.instance(new Locale("en_IND")).name().lastName();
            this.location=Faker.instance(new Locale("en_IND")).address().city();
        }
        public UpdateUserProfileRequestBody build( )
        {
            UpdateUserProfileRequestBody updateUserProfileRequestBody=new UpdateUserProfileRequestBody(this);
            return updateUserProfileRequestBody;
        }

    }
}
