package pojo.create.scoring.batsman;


import lombok.Getter;
import lombok.Setter;

@Getter
public class SetCurrentBatsmanRequestBody {
    private String striker;
    private String nonStriker;
    public SetCurrentBatsmanRequestBody(Builder builder)
    {
        this.striker=builder.striker;
        this.nonStriker=builder.nonStriker;
    }

    public static class Builder
    {
        private String striker;
        private String nonStriker;
        public Builder setStriker(String striker) {
            this.striker = striker;
            return this;
        }
        public Builder setNonStriker(String nonstriker) {
            this.nonStriker = nonstriker;
            return this;
        }
        public SetCurrentBatsmanRequestBody build()
        {

            SetCurrentBatsmanRequestBody setCurrentBatsmanRequestBody=new SetCurrentBatsmanRequestBody(this);
            return setCurrentBatsmanRequestBody;
        }

    }

}