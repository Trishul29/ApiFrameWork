package pojo.create.match;

import lombok.Getter;
import lombok.Setter;

public class RegisterBallRequestBody {

    private WagonWheel wagonWheel;

    private int runScored;

    private String runsSavedOrMissed;

    private int runType;

    private DismissalDetails dismissalDetails;

    private PitchMap pitchMap;

    private String[] extraDetails;

    private String catchDroppedFielderId;
    public RegisterBallRequestBody(Builder builder)
    {
        this.pitchMap=builder.pitchMap;
        this.catchDroppedFielderId=builder.catchDroppedFielderId;
        this.runsSavedOrMissed= builder.runsSavedOrMissed;
        this.wagonWheel=builder.wagonWheel;
        this.dismissalDetails=builder.dismissalDetails;
        this.extraDetails=builder.extraDetails;
        this.runScored= builder.runScored;
        this.runType=builder.runType;
    }


    @Setter
    @Getter
    public static class PitchMap
    {
        private Bounce bounce;
        private Pitch pitch;
        public PitchMap(Bounce bounce,Pitch pitch)
        {

        this.bounce=bounce;
        this.pitch=pitch;
        }
    }

    @Setter
    @Getter
    public static class Bounce
    {
        int X;
        int Y;
        public Bounce(int X,int Y)
        {
            this.X=X;
            this.Y=Y;
        }
    }

    @Setter
    @Getter
    public static class Pitch
    {
        int X;
        int Y;
        public Pitch(int X,int Y)
        {
            this.X=X;
            this.Y=Y;
        }
    }
    @Setter
    @Getter
    public static class DismissalDetails
    {
        private int dismissalType;
        public DismissalDetails(int dismissalType)
        {
            this.dismissalType=dismissalType;
        }
    }

    @Setter
    @Getter
    public static class WagonWheel
    {
        private int elevation;

        private int afterBounce;

        private int beforeBound;
        public WagonWheel(int elevation,int afterBounce,int beforeBound)
        {
            this.elevation=elevation;
            this.afterBounce=afterBounce;
            this.beforeBound=beforeBound;
        }
    }


    public static class Builder{
        private WagonWheel wagonWheel;

        private int runScored;

        private String runsSavedOrMissed;

        private int runType;
        private DismissalDetails dismissalDetails;

        private PitchMap pitchMap;

        private String[] extraDetails;

        private String catchDroppedFielderId;


        public Builder()
        {
            this.extraDetails=new String[]{""};
            this.runsSavedOrMissed=null;
            this.catchDroppedFielderId=null;
        }
        public Builder setDismissalDetails(int dismissalType)
        {
           this.dismissalDetails=new DismissalDetails(dismissalType);
            return this;
        }

        public Builder SetPitchMap(Bounce bounce,Pitch pitch)
        {
            this.pitchMap=new PitchMap(bounce,pitch);
            return this;

        }
        public Builder setBounce(int X,int Y)
        {
           Bounce bounce=new Bounce(X, Y);
            // this.matchVenue.setGroundName( new GroundName(placeId, name));
            this.pitchMap.getBounce().setX(X);
            this.pitchMap.getBounce().setY(Y);
            this.pitchMap.setBounce(bounce);
            return this;
        }
        public Builder setPitch(int X,int Y)
        {
            Pitch pitch=new Pitch(X, Y);
            // this.matchVenue.setGroundName( new GroundName(placeId, name));
            this.pitchMap.getPitch().setX(X);
          this.pitchMap.getPitch().setY(Y);
            this.pitchMap.setPitch(pitch);
            return this;
        }

        public Builder setWagonWheel(int elevation,int afterBounce,int beforeBound)
        {
            this.wagonWheel=new WagonWheel(elevation,afterBounce,beforeBound);
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
