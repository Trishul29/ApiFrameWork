package pojo.create.bearertoken;

import lombok.Getter;

@Getter
public class CreateBearerTokenRequestBody {
    private String email;
    private String password;
    private Boolean returnSecureToken;

    public CreateBearerTokenRequestBody(Builder builder) {
        this.email=builder.email;
        this.password=builder.password;
        this.returnSecureToken=builder.returnSecureToken;

    }

    public static class Builder {
        private String email;
        public String password;
        public Boolean returnSecureToken;



        public Builder()
        {
            this.email="troops@google.com";
            this.password="troops";
            this.returnSecureToken=true;

        }

        public CreateBearerTokenRequestBody build() {
            CreateBearerTokenRequestBody createBearerTokenRequestBody = new CreateBearerTokenRequestBody(this);

            return createBearerTokenRequestBody;

        }


    }

}
