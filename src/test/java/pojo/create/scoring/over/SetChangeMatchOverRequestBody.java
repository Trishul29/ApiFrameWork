package pojo.create.scoring.over;

import lombok.Getter;
import lombok.Setter;
@Getter
public class SetChangeMatchOverRequestBody {
    private String bowler;
    private String bowlingSide;

    public SetChangeMatchOverRequestBody(Builder builder)
    {
        this.bowler=builder.bowler;
        this.bowlingSide=builder.bowlingSide;
    }

    public static class Builder
    {
        private String bowlingSide;
        private String bowler;
        public Builder()
        {
            this.bowlingSide="around";
        }


        public Builder setBowler(String bowlerId) {
            this.bowler = bowlerId;
            return this;
        }

        public SetChangeMatchOverRequestBody build()
        {

            SetChangeMatchOverRequestBody setChangeMatchOverRequestBody=new SetChangeMatchOverRequestBody(this);
            return setChangeMatchOverRequestBody;
        }

    }
}
