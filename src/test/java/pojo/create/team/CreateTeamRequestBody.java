package pojo.create.team;

import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

import java.util.UUID;
@Getter
public class CreateTeamRequestBody {
    private String name;
    private String shortName;
    private String description;
    private String logo;

    private String banner;
    private String teamPrimaryColor;
    private String  teamSecondaryColor;
    private String teamCity;
    private Location location;

@Getter
public static class Location
{
    @Setter
    private  String placeId;
    private  double latitude;
    private  double longitude;
    private  String address;
    public Location(String placeId, double latitude, double longitude, String address) {
    this.placeId = placeId;
    this.latitude = latitude;
    this.longitude = longitude;
    this.address = address;
}

}

    public CreateTeamRequestBody(Builder builder) {
        this.name=builder.name;
        this.shortName=builder.shortName;
        this.description=builder.description;
        this.logo=builder.logo;
        this.banner=builder.banner;
        this.teamPrimaryColor=builder.teamPrimaryColor;
        this.teamSecondaryColor=builder.teamSecondaryColor;
        this.teamCity=builder.teamCity;
        this.location=builder.location;


    }


    public static class Builder {
        private String name;

        private String shortName;
        private String description;
        private String logo;

        private String banner;
        private String teamPrimaryColor;
        private String  teamSecondaryColor;
        private String teamCity;
        private Location location;

        public Builder()
        {
       this.name="Nocturn";
       this.shortName="Noc12";
       this.description="Nocturn";
       this.logo="https://dev-myysports-media-bucket.s3.ap-south-1.amazonaws.com/team_logos/Myytake+Chargers.jpg\"";
       this.banner="https://dev-myysports-media-bucket.s3.ap-south-1.amazonaws.com/team_logos/Myytake+Chargers.jpg\"";
        this.teamPrimaryColor="883662";
        this.teamSecondaryColor="883662";
        this.teamCity="Bhiwandi";

        }
        public Builder setLocation(String placeId, double latitude, double longitude, String address) {
            this.location = new Location(placeId, latitude, longitude, address);
            return this;
        }


        public CreateTeamRequestBody  build() {
            CreateTeamRequestBody    createTeamRequestBody = new CreateTeamRequestBody(this);

            return createTeamRequestBody;

        }


    }
}



