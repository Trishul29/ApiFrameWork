package pojo.update.tournament;

import lombok.Getter;
import lombok.Setter;
import util.FileUtility;

import java.util.Properties;

@Getter
public class EditTournamentRequestBody {
    private int gameType;
    private int matchType;
    private String name;
    private int totalOvers;
    private String edition;
    private String description;
    private int noOfPlayers;
    private int overPerBowler;
    private int ballType;
    private  String startsAt;
    private  String endsAt;
    private String logo;
    private String[] managers;
    private TournamentStatus tournamentStatus;
@Getter
@Setter
    public static class  TournamentStatus
    {
        String status;
        public TournamentStatus(String status)
        {
            this.status=status;
        }
    }


    public EditTournamentRequestBody(Builder builder) {
        this.gameType = builder.gameType;
        this.matchType = builder.matchType;
        this.name = builder.name;
        this.totalOvers = builder.totalOvers;
        this.edition = builder.edition;
        this.description = builder.description;
        this.noOfPlayers = builder.noOfPlayers;
        this.overPerBowler = builder.overPerBowler;
        this.ballType = builder.ballType;
        this.startsAt=builder.startsAt;
        this.endsAt=builder.endsAt;
        this.logo=builder.logo;
        this.managers=builder.managers;
    }

    public static class Builder{
        public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
        public Properties properties= FileUtility.loadProperties(propertyPath);
        private int gameType;
        private int matchType;
        private String name;
        private int totalOvers;
        private String edition;
        private String description;
        private int noOfPlayers;
        private int overPerBowler;
        private int ballType;
        private  String startsAt;
        private  String endsAt;
        private String logo;
        private String[] managers;
        private TournamentStatus tournamentStatus;

        public Builder()
        {
            this.gameType=0;
            this.matchType=0;
            this.name="Robot Tour";
            this.totalOvers=10;
            this.edition="Vampire";
            this.description="One of the best Tours";
            this.noOfPlayers=10;
            this.overPerBowler=2;
            this.ballType=1;
            this.startsAt="2023-03-28T05:30:00.000+05:30";
            this.endsAt="2023-03-29T05:30:00.000+05:30";
            this.logo="https://d14m4xvjlq5ouf.cloudfront.net/images/TournamentProfile.jpg";
            this.managers=new String[]{properties.getProperty("manager_id")};

        }
        public Builder setTournamentStatus(String status)
        {
            this.tournamentStatus=new TournamentStatus(status);
            return this;
        }
        public EditTournamentRequestBody build()
        {
            EditTournamentRequestBody editTournamentRequestBody=new EditTournamentRequestBody(this);
            return editTournamentRequestBody;
        }


    }
}
