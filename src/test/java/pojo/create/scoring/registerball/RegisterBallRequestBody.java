package pojo.create.scoring.registerball;

import lombok.Getter;

@Getter
public class RegisterBallRequestBody {
    private int runScored;

    private String runsSavedOrMissed;

    private int runType;

    private DismissalDetails dismissalDetails;


    private String[] extraDetails;

    private String catchDroppedFielderId;



    @Getter
    public static class DismissalDetails
    {
        private int dismissalType;
        public DismissalDetails(int dismissalType)
        {
            this.dismissalType=dismissalType;
        }
    }



    public RegisterBallRequestBody(Builder builder)
    {
        this.catchDroppedFielderId=builder.catchDroppedFielderId;
        this.runsSavedOrMissed= builder.runsSavedOrMissed;
        this.dismissalDetails=builder.dismissalDetails;
        this.extraDetails=builder.extraDetails;
        this.runScored= builder.runScored;
        this.runType=builder.runType;
    }



    public static class Builder{

        private int runScored;

        private String runsSavedOrMissed;

        private int runType;
        private DismissalDetails dismissalDetails;


        private String[] extraDetails;

        private String catchDroppedFielderId;


        public Builder()
        {
            this.extraDetails=new String[]{};
            this.runsSavedOrMissed=null;
            this.catchDroppedFielderId=null;
        }
        public Builder setDismissalDetails(int dismissalType)
        {
           this.dismissalDetails=new DismissalDetails(dismissalType);
            return this;
        }


        public Builder setRunScored(int runScored)
        {
          this.runScored=runScored;
            return this;
        }
        public Builder setRunType(int runType)
        {
            this.runType=runType;

            return this;
        }
        public RegisterBallRequestBody  build() {
            RegisterBallRequestBody    registerBallRequestBody = new RegisterBallRequestBody(this);
            return registerBallRequestBody;
        }

    }


}
