package pojo.create.scoring;

import lombok.Getter;

@Getter
public class CreateTossRequestBody {
    private boolean  isDigital;
    private String  callingTeam;
    private int sideCalled;
    private int tossOutcome;
    private int electedTo;
    private String battingTeam;
    private String bowlingTeam;
    public CreateTossRequestBody(Builder builder)
    {
        this.isDigital=builder.isDigital;
        this.battingTeam=builder.battingTeam;
        this.bowlingTeam=builder.bowlingTeam;
        this.tossOutcome=builder.tossOutcome;
        this.callingTeam=builder.callingTeam;
        this.electedTo=builder.electedTo;
        this.sideCalled=builder.sideCalled;

    }
    public static class Builder{
        private boolean  isDigital;
        private String  callingTeam;
        private int sideCalled;
        private int tossOutcome;
        private int electedTo;
        private String battingTeam;
        private String bowlingTeam;
        public Builder()
        {
            this.isDigital=false;
            this.sideCalled=0;
            this.tossOutcome=0;
            this.electedTo=0;

        }
        public Builder setBattingTeam(String battingTeam){
            this.battingTeam=battingTeam;
            return this;
        }
        public Builder setBowlingTeam(String bowlingTeam){
            this.bowlingTeam=bowlingTeam;
            return this;
        }
        public Builder setCallingTeam(String callingTeam)
        {
            this.callingTeam=callingTeam;
            return this;
        }
        public CreateTossRequestBody  build() {
            CreateTossRequestBody    createTossRequestBody = new CreateTossRequestBody(this);

            return createTossRequestBody;

        }

    }

}
