package pojo.create.scoring.bowler;

import lombok.Getter;
import lombok.Setter;
import pojo.create.scoring.batsman.SetCurrentBatsmanRequestBody;

@Getter
public class SetCurrentBowlerRequestBody {
    private String bowler;

    public SetCurrentBowlerRequestBody(Builder builder)
    {
this.bowler=builder.bowler;
    }
    @Setter
    public static class Builder
    {
        private String bowler;


        public Builder setBowler(String bowlerId) {
            this.bowler = bowlerId;
            return this;
        }
        public SetCurrentBowlerRequestBody build()
        {

            SetCurrentBowlerRequestBody setCurrentBowlerRequestBody=new SetCurrentBowlerRequestBody(this);
            return setCurrentBowlerRequestBody;
        }

    }


}
