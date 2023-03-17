package pojo.create.bearertoken;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateBearerTokenResponse {
    @Setter
    int statusCode;
@Setter
    String idToken;

}
