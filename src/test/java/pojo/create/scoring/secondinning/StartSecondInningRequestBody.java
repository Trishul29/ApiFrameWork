package pojo.create.scoring.secondinning;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartSecondInningRequestBody {

    private boolean followOn;

    public StartSecondInningRequestBody(Builder builder) {
        this.followOn = builder.followOn;
    }

    public static class Builder {
        private boolean followOn;

        public Builder() {
            this.followOn = false;
        }

        public StartSecondInningRequestBody build()
        {
            StartSecondInningRequestBody startSecondInningRequestBody=new StartSecondInningRequestBody(this);
            return startSecondInningRequestBody;

        }
    }

}
