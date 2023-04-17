package pojo.create.scoring.batsman;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SetNewBatsMenRequestBody {
    private String striker;
    private String nonStriker;
    public SetNewBatsMenRequestBody(Builder builder)
    {
       this.striker=builder.striker;
       this.nonStriker=builder.nonStriker;
    }
    @Setter
    public static class Builder
    {
        private String striker;
        private String nonStriker;
        public Builder setStriker(String striker) {
            this.striker = striker;
            return this;
        }
        public Builder setNonStriker(String nonStriker) {
            this.nonStriker = nonStriker;
            return this;
        }
        public SetNewBatsMenRequestBody build()
        {

            SetNewBatsMenRequestBody setNewBatsMenRequestBody=new SetNewBatsMenRequestBody(this);
            return setNewBatsMenRequestBody;
        }

    }

}
