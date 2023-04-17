package pojo.create.scoring.endinning;

import lombok.Getter;

@Getter
public class EndInningRequestBody {
    private String inningEndReason;
    private String team;

    public EndInningRequestBody(Builder builder) {
        this.inningEndReason = builder.inningEndReason;
        this.team = builder.team;
    }

    public static class Builder {
        private String inningEndReason;
        private String team;

        public Builder() {
            inningEndReason = "forfeited";
            team = "teamOne";
        }

        public EndInningRequestBody build() {
            EndInningRequestBody endInningRequestBody = new EndInningRequestBody(this);

            return endInningRequestBody;
        }
    }
}
