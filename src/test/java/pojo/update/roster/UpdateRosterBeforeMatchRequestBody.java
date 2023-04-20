package pojo.update.roster;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
public class UpdateRosterBeforeMatchRequestBody {
    private String teamId;

    private String matchId;

    private RosterData[] rosterData;

    @Getter
    @Setter
    public static class RosterData {
        private boolean isWicketKeeper;

        private boolean isSuperSub;

        private boolean isCaptain;

        private int playingStatus;

        private boolean isSubstitute;

        private User user;

        public RosterData(boolean isWicketKeeper, boolean isSuperSub, boolean isCaptain, int playingStatus, boolean isSubstitute, User user) {
            this.isWicketKeeper = isWicketKeeper;
            this.isSuperSub = isSuperSub;
            this.isCaptain = isCaptain;
            this.playingStatus = playingStatus;
            this.isSubstitute = isSubstitute;
            this.user = user;
        }
    }

    @Getter
    @Setter
    public static class User {
       // private String firstName;

      //  private String lastName;

      //  private boolean isVerified;

       // private String mobileNumber;

      //  private Location location;

      //  private String profileImage;

        private String _id;

        private String id;

     //   private String email;

        private String playingRole;
        public User(  String _id, String id,  String playingRole) {
          //  this.firstName = firstName;
           // this.lastName = lastName;
           // this.isVerified = isVerified;
          //  this.mobileNumber = mobileNumber;
           // this.location = location;
          //  this.profileImage = profileImage;
            this._id = _id;
            this.id = id;
          //  this.email = email;
            this.playingRole = playingRole;
        }
    }

//    @Getter
//    @Setter
//    public static class Location {
//        private String city;
//
//        public Location(String city) {
//            this.city = city;
//        }
//    }

    public UpdateRosterBeforeMatchRequestBody(Builder builder) {
        this.teamId = builder.teamId;
        this.matchId = builder.matchId;
        this.rosterData = builder.rosterData;
    }

    public static class Builder {

        private String teamId;

        private String matchId;

        private RosterData[] rosterData;

        public Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder setMatchId(String matchId) {
            this.matchId = matchId;
            return this;
        }

        public Builder setRosterData(RosterData[] rosterData) {
            this.rosterData = rosterData;
            return this;
        }

        public UpdateRosterBeforeMatchRequestBody build() {
            UpdateRosterBeforeMatchRequestBody updateRosterBeforeMatchRequestBody = new UpdateRosterBeforeMatchRequestBody(this);
            return updateRosterBeforeMatchRequestBody;
        }

    }



}
