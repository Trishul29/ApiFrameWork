package pojo.create.tournament;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateTournamentRequestBody {
    private int gameType;
    private int matchType;
    private String name;
    private int totalOvers;
    private String edition;
    private String description;
    private int noOfPlayers;
    private int overPerBowler;
    private int ballType;

    public CreateTournamentRequestBody(Builder builder) {
        this.gameType = builder.gameType;
        this.matchType = builder.matchType;
        this.name = builder.name;
        this.totalOvers = builder.totalOvers;
        this.edition = builder.edition;
        this.description = builder.description;
        this.noOfPlayers = builder.noOfPlayers;
        this.overPerBowler = builder.overPerBowler;
        this.ballType = builder.ballType;
    }

    public static class Builder{
        private int gameType;
        private int matchType;
        private String name;
        private int totalOvers;
        private String edition;
        private String description;
        private int noOfPlayers;
        private int overPerBowler;
        private int ballType;

     public Builder()
     {
         this.gameType=0;
         this.matchType=0;
         this.name="Cricket2022";
         this.totalOvers=0;
         this.edition=null;
         this.description="some description";
         this.noOfPlayers=11;
         this.overPerBowler=0;
         this.ballType=0;
     }
      public CreateTournamentRequestBody build()
      {
          CreateTournamentRequestBody createTournamentRequestBody=new CreateTournamentRequestBody(this);
          return createTournamentRequestBody;
      }


    }
}
