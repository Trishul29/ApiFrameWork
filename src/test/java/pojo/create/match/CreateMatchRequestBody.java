package pojo.create.match;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateMatchRequestBody {
    private int teamSize;
    private int matchType;
    private String tournamentId;
    private int totalOvers;
    private OfficialsId officialsId;
    private String startsAt;
    private TeamTwo teamTwo;
    private int overPerBowler;
    private TeamOne teamOne;
    private MatchVenue matchVenue;
    private int ballType;
    private String[] managers;
    @Getter
    @Setter
    public static class MatchVenue {
        private Address address;
        private String latitude;
        private GroundName groundName;
        private String longitude;
        public MatchVenue(Address address,  GroundName groundName, String latitude,String longitude) {
            this.address = address;
            this.latitude = latitude;
            this.groundName = groundName;
            this.longitude = longitude;
        }
    }
    @Getter
    public static class Address {
        @Setter
        private String country;

        private String city;

        private String placeId;

        public Address( String placeId,String city,String country) {

            this.placeId = placeId;
            this.city = city;
            this.country = country;

        }
    }
    @Getter
    @Setter
    public static class GroundName {
        private String placeId;
        private String name;
        public GroundName(String placeId, String name) {
            this.placeId = placeId;
            this.name = name;
        }
    }

    @Getter
    @Setter
    public static class OfficialsId {

        private String liveStreamer1;

        private String commentator1;

        private String umpire1;

        private String umpire2;

        private String scorer1;
        private String scorer2;

        public OfficialsId( String umpire1, String umpire2, String scorer1,String scorer2, String commentator1,String liveStreamer1) {
            this.liveStreamer1 = liveStreamer1;
            this.commentator1 = commentator1;
            this.umpire1 = umpire1;
            this.umpire2 = umpire2;
            this.scorer1 = scorer1;
            this.scorer2=scorer2;
        }
    }

    @Getter
    @Setter
    public static class TeamOne {
        private String teamId;
        private boolean invite;
        private RosterDetails[] rosterDetails;
        public TeamOne(String teamId, boolean invite, RosterDetails[] rosterDetails) {
            this.teamId = teamId;
            this.invite = invite;
            this.rosterDetails = rosterDetails;
        }
    }

    @Getter
    @Setter
    public static class TeamTwo {
        private String teamId;
        private boolean invite;
        private RosterDetails[] rosterDetails;
        public TeamTwo(String teamId, boolean invite, RosterDetails[] rosterDetails) {
            this.teamId = teamId;
            this.invite = invite;
            this.rosterDetails = rosterDetails;
        }
    }

    @Getter
    @Setter
    public static class RosterDetails {
        private boolean isWicketKeeper;
        private boolean isCaptain;
        private boolean isSubstitute;
        private String playerId;
        public RosterDetails(boolean isWicketKeeper, boolean isCaptain, boolean isSubstitute, String playerId) {
            this.isWicketKeeper = isWicketKeeper;
            this.isCaptain = isCaptain;
            this.isSubstitute = isSubstitute;
            this.playerId = playerId;
        }
    }

    public CreateMatchRequestBody(Builder builder) {
        this.totalOvers = builder.totalOvers;
        this.overPerBowler = builder.overPerBowler;
        this.tournamentId = builder.tournamentId;
        this.matchVenue = builder.matchVenue;
        this.ballType = builder.ballType;
        this.startsAt = builder.startsAt;
        this.teamSize =builder.teamSize;
        this.matchType = builder.matchType;
        this.officialsId = builder.officialsId;
        this.managers =builder.managers;
        this.teamOne = builder.teamOne;
        this.teamTwo = builder.teamTwo;

    }

    public static class Builder
    {
        private int teamSize;

        private int matchType;

        private String tournamentId;

        private int totalOvers;

        private OfficialsId officialsId;

        private String startsAt;

        private TeamTwo teamTwo;

        private int overPerBowler;

        private TeamOne teamOne;

        private MatchVenue matchVenue;

        private int ballType;

        private String[] managers;

        public Builder() {

            this.totalOvers = Faker.instance().number().numberBetween(1,10);
            this.overPerBowler =Faker.instance().number().numberBetween(1,20);
            this.tournamentId =null;
            this.ballType =0;
            this.startsAt = "2022-04-22 04:30:00.000";
            this.teamSize =Faker.instance().number().numberBetween(1,10);
            this.matchType = 0;
            this.managers=new String[]{"625d0fddddc6028c1761dda5"};
        }
        public Builder setMatchVenue(Address address,  GroundName groundName,String latitude, String longitude)
        {
  this.matchVenue=new MatchVenue(address,groundName,latitude,longitude);

        return this;
        }

        public Builder setGroundName(String placeId, String name)
        {
           GroundName groundName=new GroundName( placeId, name);
           // this.matchVenue.setGroundName( new GroundName(placeId, name));
            this.matchVenue.getGroundName().setPlaceId(placeId);
            this.matchVenue.getGroundName().setName(name);
            this.matchVenue.setGroundName(groundName);

        return this;
        }

        public Builder setOfficialsId(String umpire1, String umpire2, String scorer1,String scorer2,String commentator1, String liveStreamer1  )
        {
            this.officialsId=new OfficialsId(umpire1,tournamentId,scorer1,scorer2,commentator1,liveStreamer1);
            return  this;

        }
        public Builder setTeamOne(String teamId, boolean invite, RosterDetails[] rosterDetails)
        {
            this.teamOne = new TeamOne(teamId, invite, rosterDetails);
            return this;

        }
        public Builder setTeamTwo(String teamId, boolean invite, RosterDetails[] rosterDetails1)
        {
            this.teamTwo = new TeamTwo(teamId, invite,rosterDetails1);
            return this;
        }

        public CreateMatchRequestBody  build() {
          CreateMatchRequestBody    createMatchRequestBody = new CreateMatchRequestBody(this);

            return createMatchRequestBody;

        }




    }
}



